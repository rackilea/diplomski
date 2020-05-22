public void paint(Graphics g)
{
    super.paint(g); // YOU MUST CALL super.paint!!!!  

    //Clear the buffer
    Dimension d = getSize();
    checkOffscreenImage();

    //Draw the buffer
    g.drawImage(mImage, 0, 0, null);

}

private void checkOffscreenImage()
{
    Dimension d = getSize();

    if (mImage == null || mImage.getWidth(null) != d.width || mImage.getHeight(null) != d.height) {
        mImage = createImage(d.width, d.height);
        Graphics offG = mImage.getGraphics();
        offG.setColor(getBackground());
        offG.fillRect(0, 0, d.width, d.height);

        //Save frame to buffer
        paintOffscreen(offG);
        offG.dispose(); // If you create it, you must dispose of it...
    }
}