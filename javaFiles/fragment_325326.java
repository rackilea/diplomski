// to set a background we need to use bitmap  
InputStream is = getResources().openRawResource(R.Drawable.myImage);  

// we set the phone background to that image.  
Bitmap bm = BitmapFactory.decodeStream(is);  

try {  
     getApplicationContext().setWallpaper(bm);  
     //  add permission of background from manifest file  
} catch (IOException e) {  
     // TODO Auto-generated catch block  
     e.printStackTrace();  
}