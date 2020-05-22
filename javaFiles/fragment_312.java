private class DrawingPanel extends JPanel implements 
    MouseListener, MouseMotionListener {

    // The image that will store what was drawn. In the
    // mouseDragged method, the painting operations will
    // go directly to this image. When this panel is
    // painted, then ONLY this image will be painted.
    private BufferedImage bufferedImage;

    private int xPos, yPos;//mouse positions

    private DrawingPanel() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    // Make sure that the "bufferedImage" is non-null
    // and has the same size as this panel
    private void validateImage()
    {
        if (bufferedImage == null)
        {
            bufferedImage = new BufferedImage(
                getWidth(), getHeight(), 
                BufferedImage.TYPE_INT_ARGB);
            Graphics g = bufferedImage.getGraphics();
            g.setColor(getBackground());
            g.fillRect(0,0,getWidth(),getHeight());
            g.dispose();

        }
        if (bufferedImage.getWidth() != getWidth() ||
            bufferedImage.getHeight() != getHeight())
        {
            BufferedImage newBufferedImage = new BufferedImage(
                getWidth(), getHeight(), 
                BufferedImage.TYPE_INT_ARGB);
            Graphics g = newBufferedImage.getGraphics();
            g.setColor(getBackground());
            g.fillRect(0,0,getWidth(),getHeight());
            g.drawImage(bufferedImage, 0,0,null);
            g.dispose();
            bufferedImage = newBufferedImage;
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        validateImage();

        // Paint the bufferedImage which stores
        // what was drawn until now
        g.drawImage(bufferedImage, 0, 0, null);
    }


    @Override
    public void mousePressed(MouseEvent me) {
        xPos = me.getX();
        yPos = me.getY();
    }


    @Override
    public void mouseDragged(MouseEvent me) {
        int x = me.getX(), y = me.getY();
        validateImage();

        // Paint directly into the bufferedImage here
        Graphics g = bufferedImage.getGraphics();
        g.setColor(Color.BLACK);
        g.drawOval(xPos, yPos, 30, 30);
        repaint();
        xPos = x;
        yPos = y;
    }

    public void loadDrawing(BufferedImage bi) {
        //opens a message dialog and displays the image parameter
        JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(bi)));
        System.out.println("w:" + bi.getWidth() + " h:" + bi.getHeight());
    }

    public BufferedImage getScreenShot() {

        // This basically returns a "copy" of the
        // bufferedImage that stores what was drawn
        BufferedImage image = new BufferedImage(
            getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.drawImage(bufferedImage, 0, 0, null);
        g.dispose();
        return image;
    }

    //unused abstract method
    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }
}