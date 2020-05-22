class MyDrawPanel1 extends JPanel {

    private static final long serialVersionUID = 1L;
    //Image image = new ImageIcon("Koala.jpg").getImage();
     BufferedImage image;

     MyDrawPanel1() {
         super();
         try {
             this.image = ImageIO.read(getClass().getResource("com/founder/pane/Koala.jpg"))
         } catch (IOException e) {
             System.err.println("Koala.jpg does not exist!");
             e.printStackTrace();
         }
     }
     @Override
     public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 3, 4, null);
    }
}