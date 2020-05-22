public void takeScreenshot(){
    Bitmap bitmap = getScreenBitmap(); // Get the bitmap
    saveTheBitmap(bitmap);               // Save it to the external storage device.
}

public Bitmap getScreenBitmap() {
   View v= findViewById(android.R.id.content).getRootView();
   v.setDrawingCacheEnabled(true); 
   v.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), 
            MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
   v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight()); 

   v.buildDrawingCache(true);
   Bitmap b = Bitmap.createBitmap(v.getDrawingCache());
   v.setDrawingCacheEnabled(false); // clear drawing cache
   return b;
}