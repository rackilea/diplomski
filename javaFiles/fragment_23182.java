import java.awt.*;
import javax.swing.*;

// rename main to Main
public class Main extends JPanel{

        public static int WIDTH = 600;
        public static int HEIGHT = 400;

        public static void main(String args[]){ 
            Main main = new Main(); // *** create your main object ***

            JFrame f = new JFrame("FightForYourLife");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(main);  // *** add your main object to the top-level window
            f.pack();  
            f.setResizable(false);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        }

        public Main(){
            // JPanel panel = this; // this is not helpful, delete it
        }

        @Override // let the JPanel size itself.
        public Dimension getPreferredSize() {
            return new Dimension(WIDTH, HEIGHT);
        }

        @Override  // paintComponent should be protected, not public
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillRect(100, 100, 50, 30);
            System.out.println("IT IS PAINTING");
        }
}