public class MyImage extends JComponent {
   // Note: the image should be modified on the Event Dispatch Thread
   private BufferedImage image = createSkelethonizationImage();

   @Override
   public void paint(Graphics g) {
      g.drawImage(image, 0, 0, this);
   }
}