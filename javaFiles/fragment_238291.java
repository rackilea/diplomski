public void draw() {
  panel = new JPanel() {
     protected void paintComponent(Graphics g) {
        Graphics g2 = g.create();
        g2.drawImage(my_image, 0, 0, getWidth(), getHeight(), null);
        g2.dispose();
     }
  };
  panel.setBounds(0, 0, 200, 200);
  add(panel);
  revalidate();
  repaint();
  System.out.print("LOADED!!!!!!");
}