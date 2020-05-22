import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Testing extends JPanel {

    JLabel jl;
    ImageIcon icon;
    Point pointer;

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JLabel jl1 = new JLabel("Hey1");
        JLabel jl2 = new JLabel("Hey2");
        jp1.add(jl1);
        jp2.add(jl2);
        jf.add(jp1);
        jf.pack();
        jf.setVisible(true);
        Scanner myScanner = new Scanner(System.in);
        int x = myScanner.nextInt(); // the line causes the code to not work , 
        jf.getContentPane().removeAll();
        jf.add(jp2);
        jf.validate();
    }
}