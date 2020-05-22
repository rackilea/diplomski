private BufferedImage cachedImage;
...

@Override
public void paintComponent(Graphics g){
    //If the image needs to be refreshed draw it to the cache first
    if(cachedImage == null){
        cachedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        super.paintComponent(cachedImage.getGraphics());
    }

    //Draw the image from cache
    g.drawImage(cachedImage, 0, 0, this);
}