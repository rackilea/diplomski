public class JImageComponent extends JComponent {

   private static final long serialVersionUID = -6926323540532721196L;

   private final Image image;

   public JImageComponent(Image image) {
       this.image = image;
   }

   public JImageComponent(byte[] data) {
       this(Toolkit.getDefaultToolkit().createImage(data));
   }

   @Override
   protected void paintComponent(Graphics graphics) {
       graphics.drawImage(image, 0, 0, null);
   }

   @Override
   public int getWidth() {
        return image.getWidth(null);
    }

    @Override
    public int getHeight() {
        return image.getHeight(null);
    }
}