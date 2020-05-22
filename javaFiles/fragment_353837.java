master = ImageIO.read(new File("Some image some where"));
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            BufferedImage compatible = gc.createCompatibleImage(master.getWidth(), master.getHeight(), Transparency.TRANSLUCENT);
            Graphics2D g2d = compatiable.createGraphics();
            g2d.drawImage(master, 0, 0, this);
            g2d.dispose();
            master = compatible;