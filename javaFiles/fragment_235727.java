final JPanel panelC = new JPanel();
// [...]
JPanel panelCheckBoxes = new JPanel(new GridLayout(0, 1)) {
    public Dimension getPreferredSize() {
        return new Dimension(panelC.getWidth(), 
                             super.getPreferredSize().height);
    }
};