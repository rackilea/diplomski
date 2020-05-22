/* overrides the paint method */
    @Override
    public void paint(Graphics g) {
        /* clear scene buffer */
        g2d.clearRect(0, 0, (int)width, (int)height);

        /* draw ball image to the memory image with transformed x/y double values */
        AffineTransform t = new AffineTransform();
        t.translate(ball.x, ball.y); // x/y set here, ball.x/y = double, ie: 10.33
        t.scale(1, 1); // scale = 1 
        g2d.drawImage(image, t, null);

        // draw the scene (double percision image) to the ui component
        g.drawImage(scene, 0, 0, this);
    }