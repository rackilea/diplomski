public void initUI(Image img) {
    ui = new JPanel(new GridLayout(0,8));

    ImageIcon icon = new ImageIcon(img);
    for (int ii=0; ii<32; ii++) {
        ui.add(new JLabel(icon));
    }
}