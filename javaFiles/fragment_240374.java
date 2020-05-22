b5.addActionListener(e ->
   SwingUtilities.invokeLater(() -> {
       File imgFile = new File("C:\\Users\\km\\Pictures\\Cards\\green_back.png");
       Image img = ImageIO.read(imgFile);
       otaku.setImage(img);
       otaku.repaint(50L);
}));