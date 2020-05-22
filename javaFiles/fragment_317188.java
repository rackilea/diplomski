JLayeredPane layeredPane = new JLayeredPane();
{
    JPanel imagePanel = new JPanel();
    layeredPane.add(imagePanel);
    layeredPane.setLayer(imagePanel, 0);
    imagePanel.setLayout(new GridLayout(1, 2, 0, 0));
    {
        imagePanel.add(new JLabel (windows));
        imagePanel.add(new JLabel (giraffe));
    }

    layeredPane.add(status);
    layeredPane.setLayer(status, 1);
}
giraffewindow.add(layeredPane);