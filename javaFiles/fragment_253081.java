BufferedImage myPicture = null;
try {
    myPicture = ImageIO.read(getClass().getResource("/images/Report.png"));
} catch (IOException e1) {

    e1.printStackTrace();
}

JLabel headerImage = new JLabel(new ImageIcon(myPicture));