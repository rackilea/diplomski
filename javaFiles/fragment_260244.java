public class YourActivity extends Activity implements SingleUploadBroadcastReceiver.Delegate {

    private static final String TAG = "AndroidUploadService";

    private final SingleUploadBroadcastReceiver uploadReceiver =
        new SingleUploadBroadcastReceiver();

    @Override
    protected void onResume() {
        super.onResume();
        uploadReceiver.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        uploadReceiver.unregister(this);
    }

    public void uploadMultipart(final Context context) {
        try {
            String uploadId = UUID.randomUUID().toString();
            uploadReceiver.setDelegate(this);
            uploadReceiver.setUploadID(uploadId);

            new MultipartUploadRequest(context, uploadId, "http://upload.server.com/path")
                .addFileToUpload("/absolute/path/to/your/file", "your-param-name")
                .setNotificationConfig(new UploadNotificationConfig())
                .setMaxRetries(2)
                .startUpload();

        } catch (Exception exc) {
            Log.e(TAG, exc.getMessage(), exc);
        }
    }

    @Override
    public void onProgress(int progress) {
        //your implementation
    }

    @Override
    public void onProgress(long uploadedBytes, long totalBytes) {
        //your implementation
    }

    @Override
    public void onError(Exception exception) {
        //your implementation
    }

    @Override
    public void onCompleted(int serverResponseCode, byte[] serverResponseBody) {
        //your implementation
    }

    @Override
    public void onCancelled() {
        //your implementation
    }

}