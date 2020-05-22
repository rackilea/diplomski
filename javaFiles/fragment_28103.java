try {
   FileOutputStream out = new FileOutputStream(filename);
   bmp.compress(Bitmap.CompressFormat.PNG, 100, out); //100-best quality
   out.close();
} catch (Exception e) {
   e.printStackTrace();
}