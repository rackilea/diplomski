public static void main(String[] args) {
    if(currentX > SIZE_X - 1 || currentY > SIZE_Y - 1) {
        throw new IllegalStateException("Out of bounds");
    }
    for (int y = 0; y < SIZE_Y; y++) {
        drawRow(y);
    }
}