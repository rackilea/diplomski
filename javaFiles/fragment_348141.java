BufferedImage image;
int x = 100;
int y = 100;
        try {
            image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

            int color = image.getRGB(x, y);

            int  red = (color & 0x00ff0000) >> 16;
            int  green = (color & 0x0000ff00) >> 8;
            int  blue = color & 0x000000ff;
            System.out.println(red + " " + green + " " + blue);
        } catch (HeadlessException | AWTException e) {
            e.printStackTrace();
        }