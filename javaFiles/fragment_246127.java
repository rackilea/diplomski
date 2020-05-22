import java.awt.event.*;
import javax.swing.*;

public class TwoPanelTest implements ActionListener
{
    private JFrame frame;

    private JPanel panel1;
    private JPanel panel2;

    private JButton button1;
    private JButton button2;

    private JLabel label1;
    private JLabel label2;

    private JTextField tfield1;
    private JTextField tfield2;

    public TwoPanelTest()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new JPanel();
        panel2 = new JPanel();

        label1 = new JLabel("This is Label 1");
        label2 = new JLabel("This is Label 2");

        button1 = new JButton("BUTTON 1");
        button2 = new JButton("BUTTON 2");
        button1.addActionListener(this);
        button2.addActionListener(this);

        tfield1 = new JTextField(20);
        tfield2 = new JTextField(20);

        panel1.add(label1);
        panel1.add(button1);
        panel1.add(tfield1);

        panel2.add(label2);
        panel2.add(button2);
        panel2.add(tfield2);

        tfield1.setText("MY TEXT WILL CHANGE.");
        frame.setContentPane(panel1);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        JButton button = (JButton)ae.getSource();
        if (button == button1)
        {
            frame.remove(panel1);
            frame.setContentPane(panel2);
            tfield2.setText("TEXTFIELD 2");
            frame.validate();
            frame.repaint();
        }
        else if (button == button2)
        {
            frame.remove(panel2);
            frame.setContentPane(panel1);
            tfield1.setText("TEXTFIELD 1");
            frame.validate();
            frame.repaint();
        }
    }


    public static void main(String[] args)
    {
                // Here Event Dispatcher thread is responsible for 
                // calling the function which creates and displays your GUI
                // or it itself contains the code for creating and displaying
                // the GUI, to remove hickups experienced while updating the 
                // GUI on the run.
        SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    new TwoPanelTest();
                }
            });
    }
}