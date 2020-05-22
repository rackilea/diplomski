import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestButton extends JFrame  {
    private JTextField textField;
    private JButton button;
    private JTextField outField;

    public TestButton() {
        Dimension dimension = new Dimension(400,400);
        setSize(dimension);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());
        this.textField = new JTextField(10);
        this.button = new JButton("doStuff");
        this.outField = new JTextField(10);

        add(textField);
        add(button);
        add(outField);

        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                outField.setText(textField.getText());
                textField.setText("");
            }
        });

        pack();
        setVisible(true);
    }

    public static void main(String[] argv) {

        EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    TestButton testButton = new TestButton();
                }
            });
     }
}