public static void changeIcon(String championname,JLabel imageLabel) throws JavaLayerException, IOException, InterruptedException {
    imageLabel.setVisible(false);
    ImageIcon temp = new ImageIcon(getLolPath()+"\\League of Legends\\rads\\projects\\lol_air_client\\releases\\"+currentVersion+"\\deploy\\assets\\images\\champions\\"+championname+"_Square_0.png");

    imageLabel.setIcon(temp);

    imageLabel.setVisible(true);
}