public class CheckboxPanel extends JPanel {
    private final JCheckBox checkBox = new JCheckBox();
    private final Image img;

    public CheckboxPanel (final Image img0) {
        super();
        this.img = img0;

        // Left padding of 20 allows mouseovers on image that trigger the box.
        checkBox.setBorder(new EmptyBorder(0, 20, 0, 0)); 

        add(checkBox);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent me) {
                checkBox.doClick();
            }
        });
    }

    public JCheckBox getCheckBox() {
        return this.checkBox;
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }
}