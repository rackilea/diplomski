protected Bitmap doInBackground(String... urls) {
    String urldisplay = urls[0];// this parameter once had url of image  
    Bitmap cImg1= null;
    try {
        byte[] byteArray = DBcursor.getBlob(urldisplay);  
        cImg1 = BitmapFactory.decodeByteArray(byteArray, 0 ,byteArray.length);
    } catch (Exception e) {
        Log.e("Error", e.getMessage());
        e.printStackTrace();
    }
    return cImg1;
}