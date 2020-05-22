// color panel on the left side of the HsvChooser JPanel.
// Controller action: Changing selection point on this JPanel
// will notify listeners of a new COLOR selection
@SuppressWarnings("serial")
class MyColorPanel2 extends ColorPanelParent {
    private static final int CURSOR_RADIUS = 8;

    public MyColorPanel2(int prefW, int prefH, ColorProperty colorProperty) {
        super(prefW, prefH, colorProperty, true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // draws the background image

        // draws the cross hatch indicating color selection point
        g.setXORMode(Color.WHITE);
        int x = getCursorP().x;
        int y = getCursorP().y;
        int x1 = x - CURSOR_RADIUS;
        int y1 = y - CURSOR_RADIUS;
        int x2 = x + CURSOR_RADIUS;
        int y2 = y + CURSOR_RADIUS;
        g.drawLine(x1, y, x2, y);
        g.drawLine(x, y1, x, y2);
    }
}