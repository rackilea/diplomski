import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Btest {

    public int additive = 20;
    private JFrame frame;
    private JTextField txtNumber;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Btest window = new Btest();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Btest() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("btest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(4, 4, 4, 4);
        JLabel lblBtncount = new JLabel("BtnCount");
        frame.getContentPane().add(lblBtncount, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        txtNumber = new JTextField();
        txtNumber.setText("Number");
        frame.getContentPane().add(txtNumber, gbc);
        txtNumber.setColumns(10);

        JButton btnSbmt = new JButton("Sbmt");
        btnSbmt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numba = txtNumber.getText();
                int number = Integer.parseInt(numba);
                for (int amntB = 1; amntB < number + 1; amntB++) {
                    String amntS = Integer.toString(amntB);
                    JButton button = new JButton(amntS);
                    button.setBounds(327, 6 + additive, 117, 29);
                    frame.getContentPane().add(button);
                    additive += 20;
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(40, 4, 4, 4);
        frame.getContentPane().add(btnSbmt, gbc);

        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}