import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test {
    public static void main(String[] args){

        JFrame f=new JFrame("Calculator");
        f.setSize(450,450);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p=new JPanel();
        f.add(p);

        JTextField t=new JTextField(20);
        t.setBounds(5, 5, 0, 0);
        t.setLayout(null);
        p.add(t);

        JButton clear=new JButton("C");        
        clear.setBounds(5,100,50,50);
        clear.setSize(50,40);
        p.add(clear); 
        f.setVisible(true);

    }
}