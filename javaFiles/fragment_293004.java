private Drawable getShape(){
    GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[] { startColor,
            centerColor, endColor});
    gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
    gradientDrawable.setCornerRadii(getRandomFloatArray());
    gradientDrawable.setGradientCenter(0.0f, 0.45f);

    return gradientDrawable;
}

private float [] getRandomFloatArray(){
    Random rnd = new Random();
    float[] floats = new float[8];
    for (int i =0; i < floats.length; i++){
        floats[i] = rnd.nextInt(45);
    }
    return floats;
}