public static Bitmap TakeBitmapFromDialog(View v, int width, int height) {
Bitmap b = Bitmap.createBitmap(width , height, Bitmap.Config.ARGB_8888);                
Canvas c = new Canvas(b);
v.layout(0, 0, v.getLayoutParams().width, v.getLayoutParams().height);
v.draw(c);
return b;
}