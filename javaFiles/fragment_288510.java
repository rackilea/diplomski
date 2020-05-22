ProgressDialog mProgressDialog;
class DownloadFileAsync extends AsyncTask<String, String, String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressDialog = new ProgressDialog(getParent());
            mProgressDialog.setTitle("Please wait");
            mProgressDialog.setMessage("Downloading ...");
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();

    }

    @Override
    protected String doInBackground(String... aurl) {
        int count;

    try {

            URL url = new URL(aurl[0]);
            URLConnection conexion = url.openConnection();
            conexion.connect();
             //Downloading progress update
             //your downloding logic over here

              /* int lenghtOfFile= urlConnection.getContentLength();
              InputStream input = new BufferedInputStream(url.openStream());
                OutputStream output = newFileOutputStream(outputFile);

                byte data[] = new byte[1024];

                long total = 0;
                    while ((count = input.read(data)) != -1) {
                        total += count;
                        publishProgress(""+(int)((total*100)/lenghtOfFile));*/

                    }

    } catch (Exception e) {}
    return null;

    }
    @Override
    protected void onProgressUpdate(String... progress) {
         Log.d("ANDRO_ASYNC",progress[0]);
                      //Update Progress
         mProgressDialog.setProgress(Integer.parseInt(progress[0]));
    }

    @Override
    protected void onPostExecute(String unused) {

        mProgressDialog.dismiss();

    }
}