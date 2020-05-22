private BufferedImage img;

//...

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    // Create the backing buffer
    // This is a little cheat, creating a new image when the number of shapes
    // exceeds the requirements, but it saves messing about with clearing
    // a alpha image ;)
    if (img == null || shapesDrawn >= 30) {
        img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        shapesDrawn = 0;
    } else if (img.getWidth() != getWidth() || img.getHeight() != img.getHeight()) {
        // Update the backing buffer to meet the requirements of the changed screen size...
        BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D gbuffer = buffer.createGraphics();
        gbuffer.drawImage(img, 0, 0, this);
        gbuffer.dispose();
        img = buffer;
    }

    // Get a reference to the backing buffers graphics context...
    Graphics2D gbuffer = img.createGraphics();

    // Paint the shapes to the backing buffer...
    int r = (int) (Math.random() * 255);
    int gr = (int) (Math.random() * 255);
    int b = (int) (Math.random() * 255);
    Color color = new Color(r, gr, b);
    int width = 10 + (int) (Math.random() * 40);
    int height = 10 + (int) (Math.random() * 40);
    int x = (int) (Math.random() * (getWidth() - width));
    int y = (int) (Math.random() * (getHeight() - height));
    int whichShape = (int) (Math.random() * 3);
    int shapesDrawn = 0;

    switch (whichShape) {
        case 0:
            gbuffer.setColor(color);
            gbuffer.drawLine(x, y, x + width, y + height);
            shapesDrawn++;
            break;
        case 1:
            gbuffer.setColor(color);
            gbuffer.drawRect(x, y, width, height);
            shapesDrawn++;
            break;
        case 2:
            gbuffer.setColor(color);
            gbuffer.drawRoundRect(x, y, width, height, 25, 25);
            shapesDrawn++;
            break;
        case 3:
            gbuffer.setColor(color);
            gbuffer.drawOval(x, y, width, height);
            shapesDrawn++;
            break;
    }
    // Dispose of the buffers graphics context, this frees up memory for us
    gbuffer.dispose();
    // Paint the image to the screen...
    g2d.drawImage(img, 0, 0, this);
    g2d.dispose();
}