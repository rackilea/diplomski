Picture enlarged = new Picture(getWidth() * mag, getHeight() * mag);
for (int x = 0; x < getWidth(); x++) {
    for (int y = 0; y < getHeight(); y++) {
        Pixel orig = getPixel(x,y);
        for(int x2 = mag*x; x2 < mag*x+mag; x2++) {
            for(int y2 = mag*y; y2 < mag*y+mag; y2++) {
                enlarged.getPixel(x2,y2).setColor(orig.getColor());
            }
        }
    }
}