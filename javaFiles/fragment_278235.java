private void drawWall(Graphics page, Color color, int x, int y, int width,
        int height) {
    page.setColor(color);
    page.fillRect(x, y, width, height); // House base with houseColor
    page.setColor(Color.black);
    page.drawRect(x, y, width, height); // House outline
}