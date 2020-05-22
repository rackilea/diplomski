public class Sphere extends JPanel {
private boolean flashinglights = false;
private int x = 168;
private int y = 75;
private Color[] colors = new Color[] {Color.ORANGE, Color.GRAY };
private int colorIndex = 0;

public void paintComponent(Graphics g) {
   super.paintComponent(g);
   Graphics2D g2 = (Graphics2D) g;
   if (!flashinglights) {
       g2.setColor(Color.ORANGE);
       Ellipse2D.Double ball = new Ellipse2D.Double(x, y, 50, 50);
       g2.draw(ball);
       g2.fill(ball);
   } else {
       if(colorIndex > colors.length - 1)
           colorIndex = 0;

       g2.setColor(colors[colorIndex++]);
       Ellipse2D.Double ball = new Ellipse2D.Double(x, y, 50, 50);
       g2.draw(ball);
       g2.fill(ball);
   }
}

public void chooseflashinglights(){ //Ignore these methods
   flashinglights = true;
}

public void choosesteady(){
   flashinglights = false;
}

public static void main(String[] args) {
   JFrame scFrame = new AnimationViewer();
   scFrame.setTitle("Circle");
   scFrame.setSize(400, 400);
   scFrame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
   scFrame.setVisible(true);
}

}