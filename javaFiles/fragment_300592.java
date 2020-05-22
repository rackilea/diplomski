private static void somepaint(JPanel panel) {
    BufferedImage image = new BufferedImage(200,200,BufferedImage.TYPE_INT_ARGB);
    image.getGraphics().setColor(Color.red);
    image.getGraphics().fillRect(0, 0, 200, 200);

    Graphics2D graphics = (Graphics2D) panel.getGraphics();