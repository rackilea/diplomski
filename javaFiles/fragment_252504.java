private static void write(int id) {
        try {
            BufferedImage bi = ImageIO.read(new URL("http://xyz.com/abc.png"));
            BufferedImage bi2 = resizeImage(bi, bi.getType());
            Graphics g = bi2.getGraphics();
            g.drawString("Hello", 20, 20);
            ImageIO.write(bi2, "png", new File("out"+id+".png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int type){
        BufferedImage resizedImage = new BufferedImage(400, 400, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 50, 50, 248, 248, null);
        g.dispose();
        return resizedImage;
    }