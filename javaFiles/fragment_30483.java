public myPanel extends JPanel {
    static final long serialVersionUID = 1;
    public myPanel() {

        this.setPreferredSize(new Dimension(600, 40));
        this.add(new JButton("A Button"));
    }
    public void paintComponent(Graphics graphicsDrawer) {
        super.paintComponent(graphicsDrawer);

    }

}