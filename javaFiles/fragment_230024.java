@SuppressWarnings("serial")
class HangmanPanel2 extends JPanel {
    private HangmanModel model;
    private List<Image> images = ImageCreator.getImages();

    public HangmanPanel2(HangmanModel model) {
        this.model = model;
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet() || images.size() == 0) {
            return super.getPreferredSize();
        }
        int w = images.get(0).getWidth(this);
        int h = images.get(0).getHeight(this);
        return new Dimension(w, h);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(images.get(model.getValue()), 0, 0, this);
    }
}