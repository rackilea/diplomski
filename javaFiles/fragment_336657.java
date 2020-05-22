public class Test {

    public static void main(String[] args) {
       // Width and height of your image
       final int width = 200;
       final int height = 200;

       SwingUtilities.invokeLater(new Runnable() {

          @Override
          public void run() {
             JFrame frame = new JFrame();
             MyImage image = new MyImage(width, height);
             frame.add(image);
             frame.setSize(new Dimension(width, height));
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setVisible(true);            
          }
       });
    }
}

class MyImage extends JComponent {

    // Note: image should be modified on the Event Dispatch Thread only
    private final BufferedImage image;

    public MyImage(int width, int height) {
       image = createSkelethonizationImage(width, height);
       setPreferredSize(new Dimension(width, height));
    }

    public BufferedImage createSkelethonizationImage(int width, int height) {
       BufferedImage iamge = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
       Graphics2D g2 = iamge.createGraphics();

       // Perform your drawing here
       g2.setColor(Color.BLACK);
       g2.drawLine(0, 0, 200, 200);

       g2.dispose();
       return iamge;
    }

    @Override
    public void paint(Graphics g) {
       g.drawImage(image, 0, 0, this);
    }
}