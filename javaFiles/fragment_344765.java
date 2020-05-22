import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Demo extends JPanel {
    public void paintComponent(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(20,50,100,100);
    }
}
public class Example implements ActionListener {
    public void atom() {
        Demo d = new Demo();
        JFrame frame = new JFrame();  
        frame.getContentPane().add(d); //      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,200);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Example e = new Example();
        e.atom();
    }
    public void actionPerformed(ActionEvent e) {

    }
}