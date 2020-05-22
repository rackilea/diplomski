private static void savePNG( final BufferedImage image, final String path ){
        try {
            RenderedImage rendImage = image;
            ImageIO.write(rendImage, "PNG", new File(path));
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }