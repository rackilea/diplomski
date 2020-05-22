public void scrollHorizontal(int numpixels){ //allows the user to define numpixels to scroll horizontally by.
    int height = image6.getHeight();        //creates a new image that is scrolled horizontally by the entered numpixels amount.
    int width = image6.getWidth();
    horizontalscroll = new Picture(image6.getWidth(), image6.getHeight());
    for (int i = numpixels; i < width; i++){
        for (int j = 0; j < height; j++){
            pix2 = image6.getPixel(i, j);
            horizontalscroll.setPixel(i-numpixels, j, pix2);
        }
    }
    for (int i = 0; i < numpixels; i++){
        for (int j = 0; j < height; j++){
            pix2 = image6.getPixel(i, j);
            horizontalscroll.setPixel((width-numpixels) + i, j, pix2);
        }
    }
    horizontalscroll.store("scrollhorizontal.gif"); //stores new picture object to a new file.
}