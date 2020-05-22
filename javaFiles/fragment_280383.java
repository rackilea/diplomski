import java.awt.*;
import javax.swing.*;

public class LayoutMgrTest
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        //frame.setVisible(true);   
        //frame.getContentPane().setLayout(new BorderLayout());

        JPanel controlPane = new JPanel();
        JPanel buttonPane = new JPanel();

        controlPane.setLayout(new BoxLayout(controlPane, BoxLayout.PAGE_AXIS));
        controlPane.setPreferredSize(new Dimension(200, 200));
        controlPane.add(new JScrollPane(new JTextArea()));

        buttonPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonPane.setPreferredSize(new Dimension(100,40));
        buttonPane.add(new JButton("Button1"));
        buttonPane.add(new JButton("Button2"));

        frame.add(controlPane, BorderLayout.NORTH);
        frame.add(buttonPane, BorderLayout.SOUTH);
        //frame.setSize(new Dimension(500,500));
        frame.pack();
        frame.setVisible(true);
    }
}