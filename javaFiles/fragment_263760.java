public void setPixel(int r, int g, int b, int x, int y) {
    System.out.println("Called with: " + x + ", " + y); //Just added a print statement.
    synchronized (mySyncGuard){
        System.out.println("Start Draw...");
        int color = (r << 16) | (g << 8) | b;
        pixels[y * screenWidth + x] = color;
        System.out.println("End Draw...");
    }
}