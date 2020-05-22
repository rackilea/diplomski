public class MyActionListener implements ActionListener {
    private JPanel imagePanel;
    private Image image;

    public MyActionListener(JPanel imagePanel, Image image) {
        this.imagePanel = imagePanel;
        this.image = image;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println("Clicked");
        imagePanel.removeAll();
        imagePanel.add(image); //Needs Fixing
        imagePanel.revalidate();
    }
}