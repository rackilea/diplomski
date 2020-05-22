// listens for changes to both the color bar and the color panel
class InnerControl2 {
    private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(this);

    private HsvChooserPanel2 hsvChooser;
    private MyColorPanel2 colorPanel;
    private MyColorBar2 colorBar;
    private Color color; // This is all there is to the model, a "bound"
                         // property

    public InnerControl2(HsvChooserPanel2 hsvChooser, MyColorPanel2 colorPanel, MyColorBar2 colorBar) {
        this.hsvChooser = hsvChooser;
        this.colorPanel = colorPanel;
        this.colorBar = colorBar;

        // listen for changes
        colorPanel.addPropertyChangeListener(ColorPanelParent.CURSOR, new ColorPanelListener());
        colorBar.addPropertyChangeListener(ColorPanelParent.CURSOR, new ColorBarListener());
    }

    public Color getColor() {
        return color;
    }

    // classic setter method for a "bound" property
    public void setColor(Color color) {
        Color oldValue = this.color;
        Color newValue = color;
        this.color = color;
        // notify listeners of the change
        pcSupport.firePropertyChange(HsvChooserPanel2.COLOR, oldValue, newValue);
    }

    // allow outside classes the ability to listen
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.removePropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(name, listener);
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        pcSupport.removePropertyChangeListener(name, listener);
    }

    public HsvChooserPanel2 getHsvChooser() {
        return hsvChooser;
    }

    // inner listeners
    private class ColorPanelListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            Point p = colorPanel.getCursorP();
            Color c = colorPanel.getColor(p);
            colorBar.setColorPropertyValue(c);
            setColor(c); // this will fire the prop change
                                              // support
        }
    }

    private class ColorBarListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            // get hue from the color bar and use it to set the main hue
            // of the color panel
            Point p = colorBar.getCursorP();
            Color c = colorBar.getColor(p);
            colorPanel.setColorPropertyValue(c);
        }
    }
}