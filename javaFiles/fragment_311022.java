ArrayList<String> pixels_matching_color = new ArrayList<>();
    int color_to_find = Color.RED; //#FF0000 
    ImageView imageView = new ImageView(this);
    Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
    int total_width = bitmap.getWidth();
    int total_height = bitmap.getHeight();
    for (int y = 0; y < total_height; y++) {
        for (int x = 0; x < total_width; x++) {
            int pixel = bitmap.getPixel(x,y);
            //Reading colors
            int redValue = Color.red(pixel);
            int blueValue = Color.blue(pixel);
            int greenValue = Color.green(pixel);

            //finally creating the color for pixel
            int pixel_color = Color.rgb(redValue, blueValue, greenValue);
            if (pixel_color == color_to_find){
                pixels_matching_color.add(String.format("%s,%s",x,y));
            }
        }
    }
    //the array will contans the pixels that are matching the color you given
    System.out.println(pixels_matching_color);