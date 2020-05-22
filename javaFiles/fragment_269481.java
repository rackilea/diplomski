import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class FourLabelsInButton {

    private JFrame frame;
    private JButton myButton1;
    private JLabel myButton1_Label_N;
    private JLabel myButton1_Label_E;
    private JLabel myButton1_Label_W;
    private JLabel myButton1_Label_S = new JLabel();

    public FourLabelsInButton() {
        myButton1_Label_N = new JLabel("45");
        myButton1_Label_N.setHorizontalAlignment(JLabel.CENTER);
        myButton1_Label_N.setForeground(Color.red);

        myButton1_Label_E = new JLabel("1");
        myButton1_Label_E.setHorizontalAlignment(JLabel.CENTER);
        myButton1_Label_E.setForeground(Color.red);

        myButton1_Label_W = new JLabel("9");
        myButton1_Label_W.setHorizontalAlignment(JLabel.CENTER);
        myButton1_Label_W.setForeground(Color.red);

        myButton1_Label_S = new JLabel("21");
        myButton1_Label_S.setHorizontalAlignment(JLabel.CENTER);
        myButton1_Label_S.setForeground(Color.red);

        myButton1 = new JButton();
        myButton1.setBackground(Color.black);
        myButton1.setLayout(new BorderLayout());
        myButton1.add(myButton1_Label_N, BorderLayout.NORTH);
        myButton1.add(myButton1_Label_E, BorderLayout.EAST);
        myButton1.add(myButton1_Label_W, BorderLayout.WEST);
        myButton1.add(myButton1_Label_S, BorderLayout.SOUTH);

        frame = new JFrame();
        frame.add(myButton1);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                FourLabelsInButton ggg = new FourLabelsInButton();
            }
        });
    }
}