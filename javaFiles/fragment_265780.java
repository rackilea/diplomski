import java.awt.*;
import javax.swing.*;
public class GridBagLayoutDemo
{
    private JTextField tfield1;
    private JButton button1;

    private void displayGUI()
    {
        JFrame frame = new JFrame("GridBagLayout Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());

        tfield1 = new JTextField(10);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;   
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;  
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;       
        contentPane.add(tfield1, gbc);

        button1 = new JButton("More");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        contentPane.add(button1, gbc);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new GridBagLayoutDemo().displayGUI();
            }
        });
    }
}