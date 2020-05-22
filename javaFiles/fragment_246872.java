import java.awt.Graphics;
import javax.swing.JFrame;

public class Test extends JFrame{
    public static void main(String[] args){
        new Test();
    }
    public Test(){
        this.setSize(400,400);
        this.setVisible(true);
    }
    public void paint(Graphics g) {
        g.fillArc(100, 100, 100, 100, 70, 30);
    }
}