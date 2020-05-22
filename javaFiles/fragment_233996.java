int width = img.getWidth();
    int height = img.getHeight();
    int length = width * height;
    int[] pixels = new int[width*height];
    img.getPixels(pixels, 0, width, 0, 0, width, height);

    for (int i = 0; i < length; i++) {
        if (filter(pixels[i])) {
            pixels[i] = Color.rgb(0, 0, 0);
        } else pixels[i] = Color.rgb(255, 255, 255);
    }

    img.setPixels(pixels, 0, width, 0, 0, width, height);