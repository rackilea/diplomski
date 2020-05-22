BufferedImage theImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
for(int y = 0; y<100; y++){
    for(int x = 0; x<100; x++){
        int value = image[y][x] << 16 | image[y][x] << 8 | image[y][x];
        theImage.setRGB(x, y, value);
    }
}