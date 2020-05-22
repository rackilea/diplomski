import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/* <applet code=TwoPanel width=400 height=300></applet> */
public class TwoPanel extends JApplet {

    JPanel p1,p2;
    JLabel l1,l2;

    @Override
    public void init()
    {
        // JApplet defaults to BorderLayout
        System.out.println(getLayout());
        p1=new JPanel();
        p2=new JPanel();
        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());
        l1=new JLabel("Panel 1");
        l2=new JLabel("panel 2");
        p1.add(l1);
        p1.setBackground(Color.RED);
        p2.add(l2);
        p2.setBackground(Color.GREEN);
        p2.setBorder(new EmptyBorder(100,100,100,100));
        // a panel added to a BorderLayout with no constraint ends in the CENTER
        add(p1, BorderLayout.PAGE_START);
        // but the CENTER only shows ONE component.
        add(p2);
        p1.setFocusable(true);
        p2.setFocusable(true);
    }
}