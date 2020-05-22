public class MainActivity extends Activity implements PictureCallback {
    ...
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            ....
            case R.id.takePicture:
                this.mCamera.takePicture(null, null, this);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    ...
    public void onPictureTaken(byte[] data, Camera mCamera) {
        Log.d(TAG, "jpegCallback");
        String baseExternalDir = Environment.getExternalStorageDirectory().getAbsolutePath();
        String fileName = String.format("%d.jpg", System.currentTimeMillis());
        ...
        doPictureResults();
    }
}