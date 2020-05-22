private PictureCallback mPicture = new PictureCallback() {

    @Override
    public void onPictureTaken(byte[] data, Camera camera) {

       //create a Bitmap from the byte array
       Bitmap bitmap = BitmapFactory.decodeByteArray(data , 0, data.length);

       //use your Bitmap
    }
};