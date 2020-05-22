public MyPanel(boolean[][] newGrid) {
        grid = newGrid;
        //Represents an image with 8-bit RGBA color components packed into integer pixels.
        image = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
        imageG = image.createGraphics();
        //Set the single pixel line color to YELLOW using BufferedImage instance
        imageG.setColor(Color.YELLOW);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Integer cellWidth = this.getWidth() / grid.length;

        Graphics2D tempg = (Graphics2D) g;
        //Set the blocks and rest of it part to color RED
        tempg.setColor(Color.RED);

        for (Integer i = 0; i < grid.length + 1; i++) {
            imageG.drawLine(i * cellWidth, 0, i * cellWidth, this.getHeight());
        }

        tempg.fillRect(0, 0, this.getWidth(), this.getHeight());
        //Draw BufferedImage
        tempg.drawImage(image, 0, 0, this);
        //this.getGraphics().drawImage(lineImage, 0, 0, this);
    }