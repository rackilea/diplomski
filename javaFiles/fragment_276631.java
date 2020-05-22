private void drawHair(Graphics g, int ovalX, int offset, int width, int height)
{
    int arcX = ovalX - (width / 2);

    //  draw left hair

    int leftX = arcX - offset;
    g.drawArc(leftX, 125, width, height, 90, 90);

    // draw right hair

    int rightX = arcX + offset;
    g.drawArc(rightX, 125, width, height, 0, 90);
}