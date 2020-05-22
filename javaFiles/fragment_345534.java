import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

public class main {

    public static void main(String[] args){

        JFrame piyu=new JFrame("First Java app");

        JPanel panel=new JPanel();
        JLabel item1,item2;
        panel.setLayout(new GridLayout());
        item1=new JLabel("MY NAME IS XYZ");
        item2=new JLabel("YO");
        item1.setToolTipText("GAME ON");
        panel.add(item1);
        panel.add(item2);
        piyu.add(panel);

        piyu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        piyu.setSize(300,200);
        piyu.setVisible(true);

    }
}