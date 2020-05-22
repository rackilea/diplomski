public void captureView(int viewId,String filename){
    //Find the view we are after
    View    view = (View) findViewById(viewId);
    //Create a Bitmap with the same dimensions 
    Bitmap image = Bitmap.createBitmap(view.getWidth(), 
                                       view.getHeight(), 
                                       Bitmap.Config.RGB_565);
    //Draw the view inside the Bitmap
    view.draw(new Canvas(image)); 

    //Store to sdcard
    try {
       String path = Environment.getExternalStorageDirectory().toString();
       File myFile = new File(path,filename);
       FileOutputStream out = new FileOutputStream(myFile);

       image.compress(Bitmap.CompressFormat.PNG, 90, out); //Output
    } catch (Exception e) {
       e.printStackTrace();
    }
}