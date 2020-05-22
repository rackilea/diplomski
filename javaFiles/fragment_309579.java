public void paintComponent(Graphics g)
{
   super.paintComponent(g);
   g.drawImage(image, 0,0, null);
   // set the size of the panel based on image size
   setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
}