public class CustomImageView extends ImageView {

    private Bitmap myBitmap = Bitmap.createBitmap(...);

    /*
     * Constructors, etc ...
     */

    public Bitmap getBitmap() {
        return myBitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Unfortunately there's no Canvas.getBitmap, so need to be set every time
        canvas.setBitmap(getBitmap());
        super.onDraw(canvas);
    }
}