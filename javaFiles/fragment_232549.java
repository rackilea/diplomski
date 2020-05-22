// color bar on the right side of the HsvChooser JPanel.
// Controller action: Changing selection point on this JPanel
// will change the hue of the color panel
@SuppressWarnings("serial")
class MyColorBar2 extends ColorPanelParent {

    public MyColorBar2(int prefW, int prefH, ColorProperty colorProperty) {
        super(prefW, prefH, colorProperty, false);

        // create and set the background image
        setColorPropertyValue(Color.RED); // fix the magic number?
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // draws the background image

        // this draws a line at the cursor's location
        g.setXORMode(Color.WHITE);
        int y = getCursorP().y;
        g.drawLine(0, y, getPrefW(), y);
    }

}