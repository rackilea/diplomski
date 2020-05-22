public  Bitmap getCircleBitmap(Bitmap bm) {

    int sice = Math.min((bm.getWidth()), (bm.getHeight()));

    Bitmap bitmap = ThumbnailUtils.extractThumbnail(bm, sice, sice);

    Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

    Canvas canvas = new Canvas(output);


    int color = 0xff424242;
    final Paint paint = new Paint();
    final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    final RectF rectF = new RectF(rect);

    paint.setAntiAlias(true);
    paint.setDither(true);
    paint.setFilterBitmap(true);
    paint.setColor(color);
    canvas.drawARGB(0, 0, 0, 0);

    canvas.drawOval(rectF, paint);
    //canvas.drawCircle(50, 50, 50, paint);
    paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
    canvas.drawBitmap(bitmap, rect, rect, paint);

 return output;