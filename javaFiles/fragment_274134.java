import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ButtonTestFrame implements ActionListener
{
    public static final void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new ButtonTestFrame();
            }
        });
    }

    public ButtonTestFrame()
    {
        _frame = new JFrame();

        _frame.setTitle("Button test frame");

        _textArea = new JTextArea("Press some buttons:\n");
        _textArea.setEditable(false);
        _frame.add(new JScrollPane(_textArea));

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 3, 1, 1));
        _buttonA = new JButton("Button A");
        _buttonA.addActionListener(this);
        _buttonB = new JButton("Button B");
        _buttonB.addActionListener(this);
        _buttonC = new JButton("Button C");
        _buttonC.addActionListener(this);
        buttonsPanel.add(_buttonA);
        buttonsPanel.add(_buttonB);
        buttonsPanel.add(_buttonC);

        _frame.add(buttonsPanel, BorderLayout.SOUTH);

        _frame.setPreferredSize(new Dimension(600,400));
        _frame.pack();
        _frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        _frame.setLocationByPlatform(true);
        _frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event)
    {
        JButton buttonPressed = (JButton) event.getSource();

        if (_lastButtonPressed == buttonPressed)
        {
            //The same button was clicked two+ times in a row
            count++;
            _textArea.append(buttonPressed.getText() + " has been pressed " + count + " times in a row.\n");
        }
        else
        {
            //code for handling single button presses
            count = 1;
            _textArea.append(buttonPressed.getText() + " has been pressed.\n");
        }
        _lastButtonPressed = buttonPressed;
    }

    private int count = 0;
    private JButton _lastButtonPressed;
    private JButton _buttonA;
    private JButton _buttonB;
    private JButton _buttonC;
    private JTextArea _textArea;
    private JFrame _frame;
}