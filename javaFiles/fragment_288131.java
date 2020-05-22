public static void changeIcon2(URL adress,JLabel imageLabel) throws JavaLayerException, IOException, InterruptedException {
    imageLabel.setVisible(false);
    BufferedImage temp = ImageIO.read(adress);

    imageLabel.setIcon(new ImageIcon(temp));

    imageLabel.setVisible(true);
}