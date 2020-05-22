try {
   FileOutputStream out = new FileOutputStream(filename + i + ".png");
   screenshot.compress(Bitmap.CompressFormat.PNG, 90, out);
   out.flush();
   out.close();
} catch (Exception e) {
   e.printStackTrace();
}