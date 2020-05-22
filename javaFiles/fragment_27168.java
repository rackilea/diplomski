import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class MyPanel extends JPanel {

    public MyPanel(){
        JRadioButton jrb1 = new JRadioButton("Button 1");
        JRadioButton jrb2 = new JRadioButton("Button 2");
        JRadioButton jrb3 = new JRadioButton("Button 3");
        Box box1 = Box.createVerticalBox();
        box1.add(jrb1);
        box1.add(jrb2);
        box1.add(jrb3);

        JRadioButton jrb4 = new JRadioButton("Button 4");
        JRadioButton jrb5 = new JRadioButton("Button 5");
        JRadioButton jrb6 = new JRadioButton("Button 6");
        Box box2 = Box.createVerticalBox();
        box2.add(jrb4);
        box2.add(jrb5);
        box2.add(jrb6);

        JRadioButton jrb7 = new JRadioButton("Button 7");
        JRadioButton jrb8 = new JRadioButton("Button 8");
        JRadioButton jrb9 = new JRadioButton("Button 9");
        Box box3 = Box.createVerticalBox();
        box3.add(jrb7);
        box3.add(jrb8);
        box3.add(jrb9);

        setLayout(new GridLayout(1, 3));
        add(box1);
        add(box2);
        add(box3);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new MyPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);
                frame.setSize(300, 300);
                frame.setVisible(true);
            }
        });
    }
}