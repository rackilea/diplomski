public void monthScreen() {
    JButton buttonLeft = new JButton();
    buttonLeft.setPreferredSize(new Dimension(20, 20)); // for correct size
    JButton buttonRight = new JButton();
    buttonRight.setPreferredSize(new Dimension(20, 20)); // for correct size
    Dimension d = new Dimension();
    d.setSize(20, 20);
    buttonLeft.setMinimumSize(d);
    buttonLeft.setMaximumSize(d);
    buttonRight.setMinimumSize(d);
    buttonRight.setMaximumSize(d);
    JLabel label = new JLabel("Example");
    JPanel panel = new JPanel(); // add components here
    FlowLayout fl = new FlowLayout();
    fl.setHgap(0); // for some space/insets if u want
    fl.setVgap(0); // for some space/insets if u want
    panel.setLayout(fl);
    panel.add(buttonLeft);
    panel.add(label);
    panel.add(buttonRight);
    try { // in case they don't have the font, use the systems default font
        Font tr = new Font("Impact", Font.PLAIN, 18);
        label.setFont(tr);
    } catch (Exception e) {
        Font defaultFont = new JLabel().getFont();
        Font tr = new Font(defaultFont.toString(), Font.PLAIN, 18);
        label.setFont(tr);
    }
    panel1.add(panel, "cell 0 1, span, align 50% 0%, id label"); // Dont forget to add the new panel
    // panel1.add(buttonLeft, "id bl, cell 0 1");
    // panel1.add(buttonRight, "id br, cell 0 1");
}