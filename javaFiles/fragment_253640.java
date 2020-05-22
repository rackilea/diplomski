protected void paintComponent(Graphics g)
{
    super.paintComponent(g);
    int iw = image.getWidth(this);
    int ih = image.getHeight(this);

    if (iw != -1 && ih != -1)
    {
        int w = getWidth();
        int h = getHeight();
        g.drawImage(image, (w -iw)/2, (h-ih)/2, this);
    }
}