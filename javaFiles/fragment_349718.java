BufferedImage img = null;
        try {
            img = ImageIO.read(new FileInputStream(new File("image.jpg")));
        } catch (Exception e) {}

        //Scale image to 300x300
        int width = 300;
        int height = 300;
        Image scaled = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);

        //Create new buffered image
        BufferedImage tempBuff = new BufferedImage(width, height, img.getType());

         // Create Graphics object
        Graphics2D tempGraph = tempBuff.createGraphics();
        // Draw the resizedImg from 0,0 with no ImageObserver then dispose
        tempGraph.drawImage(scaled,0,0,null);
        tempGraph.dispose();

        g.drawImage((Image)tempBuff, 2, 2, this);