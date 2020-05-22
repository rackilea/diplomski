public static void main(String[] args) throws IOException {  
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    BufferedImage image = ImageIO.read(new File("./resource/patterngrey.png"));  
    TiledImage backgroundImage = new TiledImage(image);  
    // Make backgroundImage the content pane.
    mainFrame.setContentPane(backgroundImage);
    mainFrame.setLayout(new BorderLayout());
    // Make the userDetailsPanel not opaque.
    userDetailsPanel.setOpaque(false);
    mainFrame.add(userDetailsPanel, BorderLayout.CENTER);

    mainFrame.setSize(400,400);
    mainFrame.setVisible(true);
}