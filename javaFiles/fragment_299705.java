import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CheckLockingState {

    private JComponent ui = null;

    CheckLockingState() {
        initUI();
    }

    public void initUI() {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        final JLabel l = new JLabel("Click button to check locking state..");
        ui.add(l, BorderLayout.PAGE_START);

        final Toolkit t = Toolkit.getDefaultToolkit();

        ActionListener checkStateListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean b = t.getLockingKeyState(KeyEvent.VK_NUM_LOCK);
                System.out.println(b);
                l.setText("" + b);
            }
        };

        JButton b = new JButton("Check Locking State");
        b.addActionListener(checkStateListener);
        ui.add(b);
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                CheckLockingState o = new CheckLockingState();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}