import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BaseConverter extends JFrame implements ActionListener {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                BaseConverter frame = new BaseConverter("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private JTextField txtNum1;
    private JTextField txtNum2;
    private JButton btnConvert;
    private JButton btnClear;

    public BaseConverter() {
        this("Base Converter");
    }

    public BaseConverter(String title) {
        super(title);
        Container canvas = this.getContentPane();

        canvas.add(createCenterPanel(), BorderLayout.CENTER);
        canvas.add(createSouthPanel(), BorderLayout.SOUTH);

        this.setSize(400, 150);
        this.setVisible(true);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private JPanel createCenterPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("In Base 2: "));
        txtNum1 = new JTextField(16);
        panel.add(wrapMeInAPanel(txtNum1));

        panel.add(new JLabel("In Base 10: "));
        txtNum2 = new JTextField(16);
        panel.add(wrapMeInAPanel(txtNum2));

        panel.add(new JLabel("Clear boxes first!"));
        return panel;
    }

    private JPanel createSouthPanel() {
        JPanel panel = new JPanel();

        panel.add(btnConvert = new JButton("CONVERT"));
        btnConvert.setToolTipText("Remember to clear your boxes first!");
        btnConvert.addActionListener(this);
        panel.add(btnClear = new JButton("CLEAR"));
        btnClear.addActionListener(this);

        return panel;
    }

    private JPanel wrapMeInAPanel(Component c) {
        JPanel panel = new JPanel();
        panel.add(c);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConvert && txtNum2.getText().equals("")) {
            try {
                txtNum2.setText((String.valueOf((Integer.valueOf(txtNum1.getText(), 2)))));
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }
        } else if (e.getSource() == btnConvert && txtNum1.getText().equals("")) {
            try {
                txtNum1.setText(Integer.toBinaryString((Integer.valueOf(Integer.parseInt((txtNum2.getText()))))));
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }

        } else if (e.getSource() == btnClear) {
            txtNum1.setText(null);
            txtNum2.setText(null);
        }
    }
}