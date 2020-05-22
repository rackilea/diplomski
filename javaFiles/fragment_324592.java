private Bitmap getBitmap(int color) {
    Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.notification_class_icon, null);
    Canvas canvas = new Canvas();
    Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    canvas.setBitmap(bitmap);

    //set round background on lolipop+ and square before
    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(ContextCompat.getColor(context, color));
        canvas.drawCircle(canvas.getHeight()/2, canvas.getHeight()/2, canvas.getHeight()/2, p);
    }
    else {
        canvas.drawColor(ContextCompat.getColor(context, color));
    }
    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    drawable.draw(canvas);

    return bitmap;
}