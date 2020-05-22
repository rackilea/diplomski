class DownloadAsyncTask extends AsyncTask<Uri, Void, String> {
    private Uri mUri;
    CallBackTask callback;
    Context mContext;
    private AlertDialog mdialog;

    DownloadAsyncTask(Uri uri, Context context) {
        this.mUri = uri;
        mContext = context;
    }

    // In the onPreExecute() I'm displaying a custom dialog, this is not necessary, but recommended for when the user selects a large file
    @Override
    protected void onPreExecute() {
        final AlertDialog.Builder mPro = new AlertDialog.Builder(new ContextThemeWrapper(mContext, R.style.myDialog));
        @SuppressLint("InflateParams") 
        //Get reference to dialog layout
        final View mPView = LayoutInflater.from(mContext).inflate(R.layout.dialog, null);
        //Get reference to dialog title
        final TextView title = mPView.findViewById(R.id.txtTitle);
        //Get reference to dialog description
        final TextView desc = mPView.findViewById(R.id.txtDesc);

        //Set title text
        title.setText("Please wait..");
        //Set description text
        desc.setText("Drive files needs to be imported, this might take some time depending on the file size.");

        mPro.setView(mPView);
        mdialog = mPro.create();
        mdialog.show();

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected String doInBackground(Uri... params) {
        //This will be the file we will use (the one that will be copied)
        File file = null;
        try {
            //Create a temporary folder where the copy will be saved to
            File temp_folder = mContext.getExternalFilesDir("TempFolder");

            //Use ContentResolver to get the name of the original name
            //Create a cursor and pass the Uri to it
            Cursor cursor = mContext.getContentResolver().query(mUri, null, null, null, null);
            //Check that the cursor is not null
            assert cursor != null;
            int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
            cursor.moveToFirst();
            //Get the file name
            String filename = cursor.getString(nameIndex);
            //Close the cursor
            cursor.close();

            //open a InputStream by passing it the Uri
            //We have to do this in a try/catch
            InputStream is = null;
            try {
                is = mContext.getContentResolver().openInputStream(mUri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            //We now have a folder and a file name, now we can create a file
            file = new File(temp_folder + "/" + filename);

            //We can now use a BufferedInputStream to pass the InputStream we opened above to it
            BufferedInputStream bis = new BufferedInputStream(is);
            //We will write the byte data to the FileOutputStream, but we first have to create it
            FileOutputStream fos = new FileOutputStream(file);

            byte data[] = new byte[1024];
            long total = 0;
            int count;
            //Below we will read all the byte data and write it to the FileOutputStream
            while ((count = bis.read(data)) != -1) {
                total += count;
                fos.write(data, 0, count);
            }
            //The FileOutputStream is done and the file is created and we can clean and close it
            fos.flush();
            fos.close();

        } catch (IOException e) {
            Log.e("IOException = ", String.valueOf(e));
        }

        //Finally we can pass the path of the file we have copied
        return file.getAbsolutePath();


    }

    protected void onPostExecute(String result) {
        //We are done and can cancel the dialog
        if (mdialog != null && mdialog.isShowing()) {
            mdialog.cancel();
        }
        //I'm using a callback to let my Activity know that the AsyncTask is done. I pass the path along.
        callback.getResultFromAsynTask(result);


    }
}