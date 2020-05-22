private void iconSelect() {
    iconGraphPanel.removeAll();
    ImageIcon icon = new ImageIcon("image.jpg");
    BackgroundPanel imagePanel = new BackgroundPanel(icon.getImage(), BackgroundPanel.SCALED);
    iconGraphPanel.add(imagePanel);
    iconGraphPanel.revalidate();
}