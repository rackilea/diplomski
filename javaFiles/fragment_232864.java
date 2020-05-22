import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class TextFieldExample
{
    private JTextField tfield1;
    private JTextField tfield2;
    private JLabel label;
    private JButton button;
    private FocusListener tfieldListener = new FocusListener()
    {
        @Override
        public void focusGained(FocusEvent fe)
        {
        }

        @Override
        public void focusLost(FocusEvent fe)
        {
            System.out.println("I am LOST");
            String num1 = tfield1.getText().trim();
            String num2 = tfield2.getText().trim();
            if (num1 == null || num1.equals(""))
                num1 = "0";
            if (num2 == null || num2.equals(""))
                num2 = "0";         
            label.setText(Integer.toString(Integer.parseInt(num1) + Integer.parseInt(num2)));
        }
    };

    private void displayGUI()
    {
        JFrame frame = new JFrame("Text Field Focus Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        tfield1 = new JTextField(10);
        tfield2 = new JTextField(10);
        tfield2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                button.requestFocusInWindow();
            }
        });

        tfield1.addFocusListener(tfieldListener);
        tfield2.addFocusListener(tfieldListener);

        ((AbstractDocument)tfield1.getDocument()).setDocumentFilter(new MyDocumentFilter());
        ((AbstractDocument)tfield2.getDocument()).setDocumentFilter(new MyDocumentFilter());

        label = new JLabel("SUM IS");

        button = new JButton("USELESS");

        contentPane.add(tfield1);
        contentPane.add(tfield2);
        contentPane.add(label);
        contentPane.add(button);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    class MyDocumentFilter extends DocumentFilter
    {
        @Override
        public void insertString(FilterBypass fb, int offset
                                                , String text
                                                , AttributeSet aset)
        {
            try
            {
                super.insertString(fb, offset, text.replaceAll("\\D++", ""), aset);
            }
            catch(BadLocationException ble)
            {
                ble.printStackTrace();
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int len
                                           , String text
                                           , AttributeSet aset)
        {
            try
            {
                super.replace(fb, offset, len, text.replaceAll("\\D++", ""), aset);
            }
            catch(BadLocationException ble)
            {
                ble.printStackTrace();
            }
        }       
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new TextFieldExample().displayGUI();
            }
        });
    }
}