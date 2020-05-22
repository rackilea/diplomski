import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;

public class SliderExample
{
    private JSlider slider;

    private static final int MIN_BUTTONS = 2;
    private static final int SOME_BUTTONS = 4;  
    private static final int MAX_BUTTONS = 6;

    private JButton[] buttonArray;
    private ActionListener actionButton = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            JButton button = (JButton) ae.getSource();
            System.out.println(button.getText());
        }
    };

    private void createAndDisplayGUI()
    {
        ButtonPanel bp = new ButtonPanel();
        JFrame frame = new JFrame("JSlider Example : ");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLocationByPlatform(true);

        JPanel contentPane = new JPanel();
        slider = new JSlider(JSlider.HORIZONTAL, MIN_BUTTONS, MAX_BUTTONS
                                                            , SOME_BUTTONS);
        slider.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent ce)
            {
                int value = (int) slider.getValue();
                ButtonPanel.panel.removeAll();
                buttonArray = new JButton[value];
                for (int i = 0; i < value; i++)
                {
                    buttonArray[i] = new JButton(String.valueOf(i));
                    buttonArray[i].addActionListener(actionButton);
                    ButtonPanel.panel.add(buttonArray[i]);
                }
                ButtonPanel.panel.revalidate();
                ButtonPanel.panel.repaint();
            }
        });

        contentPane.add(slider);
        frame.getContentPane().add(contentPane);
        frame.pack();
        frame.setVisible(true);

        frame.requestFocusInWindow();
    }

    public static void main(String... args)
    {
        Runnable runnable = new Runnable()
        {
            public void run()
            {
                new SliderExample().createAndDisplayGUI();
            }
        };
        SwingUtilities.invokeLater(runnable);
    }
}

class ButtonPanel extends JFrame
{
    public static JPanel panel;

    public ButtonPanel()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        getContentPane().add(panel);
        setSize(300, 300);
        setVisible(true);       
    }
}