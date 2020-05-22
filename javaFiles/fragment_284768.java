class drawRect {

    private Image image;
    private JLabel label;

    public JLabel getLabel() {
        return label;
    }

    public drawRect() {
        try {
            label = new JLabel();
            image = ImageIO.read(new File("resources/1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setD(10);
    }

    public void setD(int newD) {
        int d = (newD >= 0 ? newD : 10);

        try {
            label.setIcon(new ImageIcon(resizeImage(image, d)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage resizeImage(Image originalImage, int newD) throws IOException {
        BufferedImage resizedImage = new BufferedImage(newD, newD, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, newD, newD, label);
        g.dispose();
        return resizedImage;
    }

}