ImageIcon icon90 = createImageIcon("/images/images_Right.png");
JMenuItem mntmTR90 = new JMenuItem(new AbstractAction("Rotate 90+", icon90) {
    public void actionPerformed(ActionEvent e) {
        degrees += 90;
        repaint();
    }
});