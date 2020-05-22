private int printSquares(Graphics g, int xi, int yi, int width, int height, int currentDeep) {
    //Quadrado central
    int newWidth = width / 3;
    int newHeight = height / 3;
    int x = (width / 3) + xi;
    int y = (height / 3) + yi;
    g.fillRect(x, y, newWidth, newHeight);

    int sX = 0;
    int sY = 0;
    if (currentDeep > 1) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //This is the position of each of the small rectangles
                sX = i * (width / 3) + xi;
                sY = j * (height / 3) + yi;

                // Call the method recursively in order to draw the smaller rectangles
                sum += printSquares(g, sX, sY, newWidth, newHeight, currentDeep - 1);
            }
        }
        return 1 + sum;
    } else
        return 1;
}