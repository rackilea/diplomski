import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CenteredButtons {

    private JComponent ui = null;

    CenteredButtons() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        // adjust numbers to need for minimum size/padding etc.
        ui = new JPanel(new GridLayout(0,2,40,10));
        ui.setBorder(new EmptyBorder(30,30,30,30));
        Insets margin = new Insets(10, 15, 10, 15);

        for (int i=1; i<5; i++) {
            JPanel p = new JPanel(new GridBagLayout());
            JButton btn = new JButton("Button " + i);
            btn.setMargin(margin);
            p.add(btn);
            ui.add(p);
        }
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
                CenteredButtons o = new CenteredButtons();

                JFrame f = new JFrame("Centered Buttons");
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