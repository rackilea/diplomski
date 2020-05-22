// parent of both color bar panel and color panel
@SuppressWarnings("serial")
abstract class ColorPanelParent extends JPanel {
    public static final String CURSOR = "cursor";
    private int prefW;
    private int prefH;
    private Point cursorP = new Point(0, 0);
    private BufferedImage img = null;
    private ColorProperty colorProperty;
    private boolean panel;

    public ColorPanelParent(int prefW, int prefH, ColorProperty colorProperty, boolean panel) {
        this.prefW = prefW;
        this.prefH = prefH;
        this.colorProperty = colorProperty;
        this.panel = panel;
        MyMouse myMouse = new MyMouse();
        addMouseListener(myMouse);
        addMouseMotionListener(myMouse);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(prefW, prefH);
    }

    public int getPrefH() {
        return prefH;
    }

    public int getPrefW() {
        return prefW;
    }

    public ColorProperty getColorProperty() {
        return colorProperty;
    }

    public BufferedImage getImg() {
        return img;
    }

    public Point getCursorP() {
        return cursorP;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
        repaint();
    }

    public Color getColor(Point p) {
        Color c = null;
        if (getImg() != null) {
            int rgb = getImg().getRGB(p.x, p.y);
            c = new Color(rgb);
        }
        return c;
    }

    // when the main hue is changed, we have to create a new
    // background image to reflect the new main color
    public void setColorPropertyValue(Color color) {
        int w = getPrefW();
        int h = getPrefH();
        BufferedImage img = getColorProperty().createImage(color, w, h, panel);
        setImg(img);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }
    }

    // change the cursor point and then
    // notify prop change support of changes
    private class MyMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            mouseResponse(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            mouseResponse(e);
        }

        private void mouseResponse(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            if (!contains(e.getPoint())) {
                x = Math.max(0, x);
                x = Math.min(prefW - 1, x);
                y = Math.max(0, y);
                y = Math.min(prefH - 1, y);
            }
            Point oldValue = cursorP;
            cursorP = new Point(x, y);
            firePropertyChange(CURSOR, oldValue, cursorP);
            repaint();
        }
    }

}