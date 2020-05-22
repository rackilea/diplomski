public class Scale extends JPanel{

  double scaleFactorX = 2.0;//TODO eventually change through constructor?
  double scaleFactorY = 2.0;

  public static void main(String []args){
    JFrame f = new JFrame();
    f.add(new Scale());
    f.setSize(750, 600);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void paintComponent(Graphics g){
    scaleImage((Graphics2D) g);//Call separate function
  }

  //Scales the image from "img.jpg"
  private void scaleImage(Graphics2D g) {        
    BufferedImage img = null;
    BufferedImage image = null;//is never used?!
    try {
      img = ImageIO.read(new File("img.jpg"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    Graphics2D g2d = g;
    if(img != null) {
      g2d.drawImage(img, 0, 0, null);
      g2d.drawImage(img, 0, 0, (int)(img.getWidth() * scaleFactorX), (int)(img.getHeight() * scaleFactorY), null);
    }else{
      System.out.println("Image not found!");
    }
  }
}