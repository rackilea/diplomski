public class Imageloader implements Runnable {


    @Override
    public void run() {

        Mediaimage mediaimages = new Mediaimage(NewsView.this);
        mediaimages.getimageurl(featuredmedia, new ResponseCallback() {
            @Override
            public void onImageResponse(String imageUrl) {
                ImageLoader.getInstance().displayImage(imageUrl, contentimage);
            }
        });

        //  contentimage_again = getimageurl(featuredmedia);
        Log.i("jhggggggggggggggggj", "" + contentimage_again);

        // Toast.makeText(getApplicationContext(), "hehe"+contentimage_again, Toast.LENGTH_SHORT).show();


    }
}