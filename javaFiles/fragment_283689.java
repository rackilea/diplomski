for (int i = 0; i < img.getWidth(); i++) {
    for (int j = 0; j < img.getHeight(); j++) {
        int rgb = img.getRGB(i, j);
        int origRGB = origImg.getRGB(i, j);              
        int redPixel = red ? (origRGB >> 16) & r : (rgb >> 16) & r;
        int greenPixel = green ? (origRGB >> 8) & g : (rgb >> 8) & g;
        int bluePixel = blue ? origRGB & b : rgb & b;
        int gbr = (redPixel << 16) | (greenPixel << 8) | bluePixel;
        tmp.setRGB(i, j, gbr); 
   }
}