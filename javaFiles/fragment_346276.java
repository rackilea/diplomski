import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class TestApplication extends JFrame {
    public static void main(String [] a){
        TestApplication ta = new TestApplication();
        TBar t = new TBar();
        ta.setLayout(new BorderLayout());
        ta.add(t,BorderLayout.NORTH);
        ta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ta.setPreferredSize(new Dimension(400,300));
        ta.pack();
        ta.setVisible(true);
    }
}

class TBar extends JToolBar{
    JButton b = new JButton("Hello");

    public TBar(){
        add(b);
    }
}