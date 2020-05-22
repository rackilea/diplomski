private Drawable invertImage(Drawable inputDrawable){
    Bitmap bitmap = ((BitmapDrawable) inputDrawable).getBitmap();

    int width = bitmap.getWidth();
    int height = bitmap.getHeight();

    int[] pixels = new int[width * height];
    bitmap.getPixels(pixels, 0, width, 0, 0, width, height);

    int[] finalArray = new int[width * height];

    for(int i = 0; i < finalArray.length; i++) {
        int red = Color.red(pixels[i]);
        int green = Color.green(pixels[i]);
        int blue = Color.blue(pixels[i]);
        finalArray[i] = Color.rgb(blue, green, red);
    }
    bitmap = Bitmap.createBitmap(finalArray, width, height, Bitmap.Config.ARGB_8888);

    return new BitmapDrawable(getResources(),bitmap);
}