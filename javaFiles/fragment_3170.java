public void display() {

    double tempX = 0;
    double tempY = 0;
    double size = 50;

    for (int r = 0; r < cells.length; r++) {
        for (int c = 0; c < cells[r].length; c++) {

            cells[r][c].display(tempX, tempY, size);

            tempX += 50;
        }

        tempY += 50;
        tempX = 0;           // <-------------- look here

    }
}