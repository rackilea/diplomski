class ImageCreator {
    private static final int W = 284;
    private static final int H = 425;
    private static final Color BASE_COLOR = new Color(205, 133, 63);

    public static List<Image> getImages() {
        List<Image> images = new ArrayList<>();
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        images.add(createImageCopy(img));
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(BASE_COLOR);
        int xArc = W / 20;
        int yArc = H - H / 5;
        int arcWidth = W / 2;
        int arcHeight = H / 5;

        g2.fillArc(xArc, yArc, arcWidth, arcHeight, 0, 180);


        images.add(createImageCopy(img));

        // -----------------------------------------

        g2.setColor(Color.BLACK);
        int x1Line = xArc + arcWidth / 2;
        int x2Line = x1Line;
        int y1Line = yArc;
        int y2Line = H / 6;

        g2.drawLine(x1Line, y1Line, x2Line, y2Line);

        images.add(createImageCopy(img));

        // -----------------------------------------

        int x3Line = x1Line;
        int x4Line = x3Line + (W / 3) + 20;
        int y3Line = y2Line;
        int y4Line = y3Line;

        g2.drawLine(x3Line, y3Line, x4Line, y4Line);

        images.add(createImageCopy(img));

        // -----------------------------------------

        int x5Line = x4Line;
        int x6Line = x5Line;
        int y5Line = y4Line;
        int y6Line = y5Line + W / 5; // + 60

        g2.drawLine(x5Line, y5Line, x6Line, y6Line);

        // -----------------------------------------

        g2.setColor(new Color(255, 221, 204));
        g2.fillOval(x6Line - H / 20, y6Line, H / 10,
                H / 10); // -25, ...,50, 50

        images.add(createImageCopy(img));

        // -----------------------------------------

        g2.setColor(Color.BLUE);
        g2.fillOval((int) ((int) x6Line - H / 14.7),
                (int) (y6Line + H / 10.41), (int) (H / 7.14),
                (int) (H / 4.16)); // 34, 48, 70, 120

        images.add(createImageCopy(img));

        // -----------------------------------------

        int x7Line = x6Line + (int) (H / 17.85); // 28
        int x8Line = x7Line + (int) (H / 12.5); // 40
        int y7Line = y6Line + (int) (H / 7.14); // 70
        int y8Line = y7Line - (int) (H / 14.28); // 35

        g2.setColor(Color.BLACK);
        g2.drawLine(x7Line, y7Line, x8Line, y8Line);

        images.add(createImageCopy(img));

        // -----------------------------------------

        int x9Line = x7Line - (int) (H / 9.43); // 53
        int x10Line = x9Line - (int) (H / 14.28); // 35
        int y9Line = y7Line;
        int y10Line = y8Line;

        g2.drawLine(x9Line, y9Line, x10Line, y10Line);

        images.add(createImageCopy(img));

        // -----------------------------------------

        int x11Line = x7Line;
        int x12Line = x8Line;
        int y11Line = y7Line + (int) (H / 6.66); // 75
        int y12Line = y8Line + (int) (H / 3.33); // 150

        g2.drawLine(x11Line, y11Line, x12Line, y12Line);

        images.add(createImageCopy(img));

        // -----------------------------------------

        int x13Line = x9Line;
        int x14Line = x10Line;
        int y13Line = y11Line;
        int y14Line = y12Line;

        g2.drawLine(x13Line, y13Line, x14Line, y14Line);
        images.add(createImageCopy(img));

        g2.dispose();
        return images;
    }

    private static Image createImageCopy(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage img2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img2.getGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return img2;
    }
}