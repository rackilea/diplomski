public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int currX = 10, currY = 10; // A 10px offset
    int gridBoxSize = 50; // In pixels. Should be large enough for three digits.

    for (int i = 0; i < array.length; i++) {
        if (currX + gridBoxSize > this.getWidth()) {
            currX = 10;
            currY += gridBoxSize;
        }
        g.setColor(Color.BLACK);
        g.drawRect(currX, currY, gridBoxSize, gridBoxSize);
        g.drawString(new String(array[i]), currX + 2, currY + 2);
    }
}