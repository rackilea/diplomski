import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextFieldExample
{
    private JFrame frame;
    private JPanel contentPane;
    private JTextField tfield;
    private JButton button;
    private int size = 10;

    private ActionListener action = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            String input = JOptionPane.showInputDialog(
                                frame, "Please Enter Columns : "
                                                , String.valueOf(++size));
            tfield.setColumns(Integer.parseInt(input));                 
            contentPane.revalidate();
            contentPane.repaint();
        }
    };

    private void createAndDisplayGUI()
    {
        frame = new JFrame("JTextField Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           

        contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        tfield = new JTextField();
        tfield.setColumns(size); 

        JButton  button = new JButton("INC Size");
        button.addActionListener(action);

        contentPane.add(tfield);
        contentPane.add(button);

        frame.getContentPane().add(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new JTextFieldExample().createAndDisplayGUI();
            }
        });
    }
}