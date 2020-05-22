import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MultiFrames implements ActionListener
{
    private JFrame frame1, frame2, frame3;
    private String message;
    private JTextField txtFiled;
    private JButton btn1, btn2;
    private JLabel lbl;
    private boolean flag = false;

    private static final String BUTTON1_COMMAND = "btn1";
    private static final String BUTTON2_COMMAND = "btn2";

    public MultiFrames()
    {
        frame1 = new JFrame("JFrame #1");
        frame2 = new JFrame("JFrame #2");
        frame3 = new JFrame("JFrame #3");

        frame1.setLayout(new FlowLayout());
        frame2.setLayout(new FlowLayout());
        frame3.setLayout(new FlowLayout());

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(200, 100);
        frame1.setLocationRelativeTo(null);

        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(200, 100);
        frame2.setLocationRelativeTo(null);

        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(200, 100);
        frame3.setLocationRelativeTo(null);

        txtFiled = new JTextField(10);
        frame2.add(txtFiled);

        lbl = new JLabel();
        frame3.add(lbl);

        btn1 = new JButton("Open JFrame #2");
        btn2 = new JButton("Re-Open JFrame #1");

        btn1.addActionListener(this);
        btn1.setActionCommand(BUTTON1_COMMAND);
        btn2.addActionListener(this);
        btn2.setActionCommand(BUTTON2_COMMAND);

        frame1.add(btn1);
        frame2.add(btn2);

        frame1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        if(s.equals(BUTTON1_COMMAND))
        {
            if(!flag)
            {
                frame1.setVisible(false);
                frame2.setVisible(true);
                flag = true;
            }
            else
            {
                frame1.setVisible(false);
                frame3.setVisible(true);
                lbl.setText("The word is: " + message);
            }
        }
        else if(s.equals(BUTTON2_COMMAND))
        {
            frame2.setVisible(false);
            frame1.setVisible(true);
            message = txtFiled.getText();
            btn1.setText("Open JFrame #3");
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new MultiFrames();
            }
        });
    }
}