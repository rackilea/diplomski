public static void main(String[] args) {
    JFrame frame = new JFrame();
    final Container panel = frame.getContentPane();
    panel.setLayout(new FlowLayout());

    // create an image an draw in it.
    final BufferedImage image = new BufferedImage(
        200, 200, BufferedImage.TYPE_INT_ARGB);
    Graphics g = image.getGraphics();
    g.setColor(Color.RED);
    g.drawLine(0, 0, image.getWidth(), image.getHeight());

    Icon iImage = new ImageIcon(image);
    // create a label with the icon.
    final JLabel label = new JLabel(iImage);
    panel.add(label);
    // create a new button.
    JButton button = new JButton("resize");
    // add an action to the button.
    button.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            // set the label with a new icon.
            BufferedImage bi = new BufferedImage(
                100, 100, BufferedImage.TYPE_INT_ARGB);
            bi.getGraphics().drawImage(image, 0, 0, null);
            label.setIcon(new ImageIcon(bi));
        }
    });
    // add the button to the frame.
    panel.add(button);
    // open the frame.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
}