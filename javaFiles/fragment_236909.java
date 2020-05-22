public void paint(Graphics g) {
         Graphics2D g2d = (Graphics2D)g;
            int w = this.getWidth();
            int h = this.getHeight();
            if(orginalImage == null )return;

            int imageWidth = orginalImage.getWidth();
            int imageHeight = orginalImage.getHeight();
            BufferedImage bi = new BufferedImage(
                    (int)(imageWidth*scale), 
                    (int)(imageHeight*scale), 
                    orginalImage.getType());

            Graphics2D g2 = bi.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.translate(point.x, point.y);
            g2d.scale(scale, scale);
            g2d.translate(-point.x, -point.y);
            //g2d.translate(-w/2, -h/2);
            g2d.drawImage(orginalImage, 0, 0, w, h, null);

            this.setPreferredSize(new Dimension(orginalImage.getWidth(), orginalImage.getHeight()));
            if(selection == null) return;

            g2d.setStroke(new BasicStroke(2));
            g2d.setColor(Color.RED);
            g2d.draw(selection);

            resizeImage();
     }`