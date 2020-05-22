public class CameraActivity extends Activity {
    private static final String TAG = "CameraActivity";
    String currentFilePath;
    String currentFileName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new CameraTask().execute();
    }

    public void dispatchPictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException e) {
                Toast.makeText(this, R.string.msg_picture_not_saved, Toast.LENGTH_LONG).show();
            }
            if (photoFile != null) {
                Uri photoUri = FileProvider.getUriForFile(this, getClass().getCanonicalName(), photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(takePictureIntent, Constants.REQUEST_TO_TAKE_PICTURE);

            }
        }
    }

    public File createImageFile() throws IOException {
        File pathOfStorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM + "/Camera");
        pathOfStorageDir.mkdir();

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePrefix = "img_" + timeStamp + "_";
        String suffix = ".jpg";

        File image = File.createTempFile(filePrefix, suffix, pathOfStorageDir);
        currentFileName = image.getName();
        currentFilePath = image.getAbsolutePath();
        return image;
    }

    private void addPictureToGallery() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(currentFilePath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

    private void dispatchDataIntent() {
        Intent data = new Intent();
        data.putExtra(Constants.IMAGE_FILE_NAME, currentFileName);
        setResult(CameraActivity.RESULT_OK, data);
    }

    private class CameraTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            dispatchPictureIntent();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_TO_TAKE_PICTURE){
            if(resultCode == RESULT_OK) {

                addPictureToGallery();
                dispatchDataIntent();
            } else {
                File f = new File(currentFilePath);
                f.delete();
            }
        }
            finish();

    }