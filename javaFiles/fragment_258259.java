final View v; // The view that you want to save as an image
Bitmap bitmap = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
Canvas c = new Canvas(bitmap);
v.draw(c);
File outputFile; // Where to save it
FileOutputStream out = new FileOutputStream(imageFile);
boolean success = bitmap.compress(CompressFormat.PNG, 100, out);
out.close();