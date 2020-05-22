public void jButton1_ActionPerformed(ActionEvent evt) {
    BufferedImage image=new BufferedImage(jPanel1.getWidth(), jPanel1.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
    Graphics2D g = image.createGraphics();
    g.fillRect(0, 0, image.getWidth(), image.getHeight());
    g.setColor(Color.BLUE);
    g.drawLine(0, 0, 300, 400);
    g.dispose();
    JLabel l=new JLabel(new ImageIcon(image));
    jPanel1.add(l);
}