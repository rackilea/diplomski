import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpdateLabel
{
    private JLabel label;
    private String labelText;

    private ActionListener action = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            setLabelText((String) ae.getActionCommand());
            label.setText(getLabelText());
        }
    };

    private void setLabelText(String text)
    {
        labelText = text;
    }

    private String getLabelText()
    {
        return labelText;
    }

    private void createAndDisplayGUI()
    {
        final JFrame frame = new JFrame("Update Label");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationByPlatform(true);

        JMenuBar menuBar = new JMenuBar();
        JMenu programMenu = new JMenu("Program");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                frame.dispose();
            }
        });
        JMenu labelMenu = new JMenu("Label");
        JMenuItem updateMenuItem = new JMenuItem("Update Label");
        updateMenuItem.setActionCommand("Updated by JMenuItem");
        updateMenuItem.addActionListener(action);

        programMenu.add(exitMenuItem);
        labelMenu.add(updateMenuItem);
        menuBar.add(programMenu);
        menuBar.add(labelMenu);

        frame.setJMenuBar(menuBar);

        JPanel contentPane = new JPanel();

        label = new JLabel("I am the LABEL which will be updated!!");
        contentPane.add(label);

        JTextField tfield = new JTextField(10);
        tfield.setActionCommand("Updated by JTextField");
        tfield.addActionListener(action);

        frame.add(contentPane, BorderLayout.CENTER);
        frame.add(tfield, BorderLayout.PAGE_END);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new UpdateLabel().createAndDisplayGUI();
            }
        });
    }
}