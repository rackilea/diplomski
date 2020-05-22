public class flip extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set view to our created view
        setContentView(new drawView(this));
    }

    private class drawView extends View{
        public drawView(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            //Load the jellyfish drawable
            Bitmap sprite = BitmapFactory.decodeResource(this.getResources(), R.drawable.jellyfish);

            //Create a matrix to be used to transform the bitmap
            Matrix mirrorMatrix = new Matrix();

            //Set the matrix to mirror the image in the x direction
            mirrorMatrix.preScale(-1.0f, 1.0f);

            //Create a flipped sprite using the transform matrix and the original sprite
            Bitmap fSprite = Bitmap.createBitmap(sprite, 0, 0, sprite.getWidth(), sprite.getHeight(), mirrorMatrix, false);

            //Draw the first sprite
            canvas.drawBitmap(sprite, 0, 0, null);

            //Draw the second sprite 5 pixels to the right of the 1st sprite
            canvas.drawBitmap(fSprite, sprite.getWidth() + 5, 0, null);
        }
    }
}