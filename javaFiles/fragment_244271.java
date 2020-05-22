public class ProcessImage {
    public void getAnImage(final BitmapCallback callback /* , other formal args */) {
        new Thread() {
            @Override
            public void run() {
                Bitmap bitmap;
                . . . // do the work
                // then deliver the results
                callback.onBitmapReady(bitmap);
            }
        }.start();
    }
}