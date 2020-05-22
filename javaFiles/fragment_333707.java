@Override
public void paintComponent(Graphics g) {
   super.paintComponent(g);
   Graphics2D g2 = (Graphics2D) g;
   g2.setColor(Color.RED);
   g2.drawString("John", 5, 100);
}