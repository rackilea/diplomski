private void drawHouses() {
    // make an array of colors
    Color[] colors = new Color[] { Color.RED, Color.BLUE, Color.GREEN };

    // loop through the colors
    for(int i = 0 ; i < colors.length; i ++ ) {
       // use the index of the loop for the position of the house and for the current color.
       drawHouse(i * 50, 100, colors[i]);
    }
}

private void drawHouse(int x, int y, Color color) {
    // draw house here

}