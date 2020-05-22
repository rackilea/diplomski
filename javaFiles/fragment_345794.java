Bitmap textToBitmap(String text)
{
     Paint paint = new Paint();
     paint.setColor(Color.WHITE);
     paint.setStrokeWidth(12);
     Rect bounds = new Rect();
     paint.getTextBounds(text, 0, text.length(), bounds);
     Bitmap bitmap = Bitmap.createBitmap(bounds.width(), bounds.height(), Bitmap.Config.ARGB_8888);
     Canvas canvas = new Canvas(bitmap);
     canvas.drawText(text, 0, 0, paint);
     return bitmap;
}