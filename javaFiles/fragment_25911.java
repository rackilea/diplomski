import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Object6 extends JFrame {
    JPanel a = new JPanel();
    JButton p = new JButton("Y");
    JButton n = new JButton("N");
    Color c = new Color(0x4BBCF8);
    JLabel b = new JLabel("Does statement 6 apply?");

    public Object6(){
        setVisible(true);                               
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1280,800);
        setBackground(c);
        panel();
    }
    public void panel(){
        a.setLocation(540,600);
        a.setSize(200,50);
        add(a);
        a.setLayout(null);

        p.setLocation(0,0);
        n.setLocation(100,0);
        p.setSize(100,50);
        n.setSize(100,50);
        a.add(p);
        a.add(n);

        int e = b.getText().length();
        b.setLocation((1280-e*8)/2,100);
        b.setSize(8*e,16);
        add(b);
    }
    public static void main(String[]args){
        new Object6();
    }
}