try {
        BufferedImage image = new BufferedImage(mypanel.getWidth(),
                mypanel.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g = image.getGraphics();
        mypanel.printAll(g);
        g.dispose();
        ImageIO.write(image, "png", new File("img.png"));
    } catch (Exception e) {
        e.printStackTrace();
    }