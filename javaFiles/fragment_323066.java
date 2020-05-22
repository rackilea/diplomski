public class ImgUtility {

    public Bitmap createRankingImg(Context context, int difficulty) {

        // Create a Bitmap image starting from the star.png into the "/res/drawable/" directory:
        Bitmap myBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.chef_hat_ok);
        return myBitmap;

    }

}