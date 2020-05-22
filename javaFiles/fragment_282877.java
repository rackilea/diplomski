try{
    Bitmap bm = BitmapFactory.decodeResource(getResources(), 
    R.drawable.ic_launcher);
    bm = Bitmap.createBitmap(bm, 0, 0, 400, 400);
    your_imageview.setImageBitmap(bm);
}catch(Exception e){
      e.printStackTrace();     
}