// Define a method to generate a bitmap shader from a drawable resource
private static Shader getDrawableShader(Context ctx, int resId) {
    Bitmap bmp = BitmapFactory.decodeResource(ctx.getResources(), resId);
    return new BitmapShader(bmp, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
}

// Outside of onDraw(), preferably on a background thread if possible
Shader shader = getDrawableShader(getContext(), R.drawable.my_image);

// In onDraw()
paint.setShader(shader);
canvas.drawArc(rectF, 0, 360, true, paint);