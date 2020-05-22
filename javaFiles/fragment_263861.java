import javax.swing.*;
import java.awt.*;

public class DrawRoom extends JPanel {

    Image image;

        public DrawRoom() {
            this.image = Toolkit.getDefaultToolkit().getImage("0112091251.jpg"); 
        }

        public void paintComponent(Graphics g){
            g.drawImage(image,0,0,640,480, this);
        }

        public void changeImage(String whichImage){
            this.image = Toolkit.getDefaultToolkit().getImage(whichImage);
            this.repaint();
        }
    }