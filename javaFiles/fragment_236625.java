char[][] kreis(char[][] zf, int xM, int yM, int r, char z){
    try {
        for (int x = xM - r; x <= xM + r; x++) {
            int y = (int) Math.sqrt(Math.pow(r, 2) - Math.pow(x - xM, 2)) + yM;
            zf[x][y] = z;
            zf[x][2 * yM - y] = z;
        }
    } catch(IndexOutOfBoundsException e) {
        System.out.println("Error, circle out of bounds.");
    }
    return zf;
}