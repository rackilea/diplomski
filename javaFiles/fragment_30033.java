private void drawCirlce(Graphics g, Color blue, Color yellow, int dimension) {

    g.setColor(Color.WHITE);
    g.fillOval((getHeight() - (dimension)) / 2, (getWidth() - (dimension)) / 2, dimension, dimension);
    g.setColor(Color.BLACK);
    g.drawOval((getHeight() - (dimension)) / 2, (getWidth() - (dimension)) / 2, dimension, dimension);
    // Updated code here:
    dimension -= 30;
    g.drawOval((getHeight() - (dimension)) / 2, (getWidth() - (dimension)) / 2, dimension, dimension);

}//end drawCircle