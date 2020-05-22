public static void findBlueLine(Picture p) {
    Pixel[][] pixels = p.getPixels2D();
    Bool aboveLine = false;

    for (int x = 0; x < p.getWidth(); x++) {
        aboveLine = false;        

        for(int y = p.getHeight-1; 0 <= y ; y--) {
            if(aboveLine == true) {
                pixels[y][x].setColor(Color.BLACK);
            }

            if (isBlueLine(pixels[y][x])) {
                aboveLine = true;
            }  
        }

    }
}