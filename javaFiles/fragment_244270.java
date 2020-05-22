public class MyActivity extends Activity implements BitmapCallback {
    Handler mHandler; // initialize this in onCreate
    . . .

    public void onRequestImage() {
        ProcessImage processor = new ProcessImage();
        getImage(this /* , other actual args */);
    }

    @Override
    public void onBitmapReady(final Bitmap processedBitmap) {
        // since this may be called from a non-UI thread, we can't update
        // the UI directly.
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                // handle the bitmap (update the UI, etc.)
            }
        });
    }
}