try {
    BufImage = ImageIO.read(getClass().getResource("/quest2/Logo.png"));
} catch (IOException e) {
    e.printStackTrace();
}

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);
setSize(720, 480);
setTitle("Quest 2");
if (BufImage != null) {
    ImageIcon ii = new ImageIcon(BufImage);
    image = ii.getImage();
    setIconImage(image);
}
setLocationRelativeTo(null);
setVisible(true);