public static Image resizeImage(Display display, Image image, int width, int height) {

    Image scaled = new Image(display, width, height);
    GC gc = new GC(scaled);
    gc.setAntialias(SWT.ON);
    gc.setInterpolation(SWT.HIGH);
    gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 0, 0, width, height);
    gc.dispose();

    ImageData canvasData = scaled.getImageData();
    canvasData.alphaData = new byte[width * height];

    // This is the hacky bit that is making assumptions about
    // the underlying ImageData. In my case it is 32 bit data
    // so every 4th byte in the data array is the alpha for that
    // pixel...
    for (int idx = 0; idx < (width * height); idx++) {
        int coord = (idx * 4) + 3;
        canvasData.alphaData[idx] = canvasData.data[coord];
    }

    // Now that we've set the alphaData, we can create our
    // final image
    Image finalImage = new Image(display, canvasData);

    scaled.dispose();

    return finalImage;
}