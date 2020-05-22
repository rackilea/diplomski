try {
            BufferedImage inputImage = ImageIO.read(new File("input.jpg"));

            BufferedImage outputImage = new BufferedImage(
                    inputImage.getWidth(), inputImage.getHeight(),
                    BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < inputImage.getWidth(); x++) {
                for (int y = 0; y < inputImage.getHeight(); y++) {
                    int rgb = inputImage.getRGB(x, y);
                    int blue = 0x0000ff & rgb;
                    int green = 0x0000ff & (rgb >> 8);
                    int red = 0x0000ff & (rgb >> 16);
                    int lum = (int) (red * 0.299 + green * 0.587 + blue * 0.114);
                    outputImage
                            .setRGB(x, y, lum | (lum << 8) | (lum << 16));
                }
            }
            ImageIO.write(outputImage, "jpg", new File("output.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }