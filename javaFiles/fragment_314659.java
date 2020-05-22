import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ChangeDemo {

    private JButton jbtn;
    private JLabel jlab;

    public ChangeDemo() {
        JFrame jfrm = new JFrame("Button Change Events");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setLayout(new GridLayout(0, 1));
        jlab = new JLabel("", JLabel.CENTER);
        jbtn = new JButton("Press for Change Event Test");
        jbtn.setRolloverEnabled(true);

        jbtn.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent ce) {
                ButtonModel mod = jbtn.getModel();
                String what = "";

                if (mod.isEnabled()) {
                    what += "Enabled<br>";
                }
                if (mod.isRollover()) {
                    what += "Rollover<br>";
                }
                if (mod.isArmed()) {
                    what += "Armed<br>";
                }
                if (mod.isPressed()) {
                    what += "Pressed<br>";
                }

                //Notice that this label's text is HTML
                jlab.setText("<html>Current stats:<br>" + what + "</html>");
            }
        });

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(50, 10, 0, 10));
        panel.add(jbtn);
        jfrm.add(panel);
        jfrm.add(jlab);

        jfrm.pack();
        jfrm.setLocationRelativeTo(null);
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        //Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ChangeDemo changeDemo = new ChangeDemo();
            }
        });
    }
}