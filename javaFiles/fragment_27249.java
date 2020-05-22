Bitmap b=BitmapFactory.decodeResource(CON.getResources(),R.drawable.deltio);
Bitmap bmOverlay = Bitmap.createBitmap(b.getWidth(), b.getHeight(), b.getConfig());
canvas = new Canvas(bmOverlay);
Paint paint = new Paint();
paint.setColor(Color.RED);
canvas.drawBitmap(b, new Matrix(), null);
canvas.drawCircle(750, 14, 11, paint);