import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class AppletWithButtonsOnRight {

    private JComponent ui = null;

    AppletWithButtonsOnRight() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new TitledBorder("BorderLayout(4,4)"));

        JPanel appletPanel = new JPanel(new GridLayout());
        appletPanel.setBackground(Color.RED);
        appletPanel.add(new JLabel(new ImageIcon(new BufferedImage(400, 300, BufferedImage.TYPE_INT_ARGB))));
        ui.add(appletPanel);

        JPanel menuPanel = new JPanel(new BorderLayout());
        menuPanel.setBorder(new TitledBorder("BorderLayout()"));
        ui.add(menuPanel, BorderLayout.LINE_END);

        JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        buttonPanel.setBorder(new TitledBorder("GridLayout(0,1,10,10)"));
        menuPanel.add(buttonPanel, BorderLayout.PAGE_START);

        for (int i=1; i<5; i++) {
            JButton b = new JButton("Button " + i);
            b.setFont(b.getFont().deriveFont(24f));
            buttonPanel.add(b);
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
                AppletWithButtonsOnRight o = new AppletWithButtonsOnRight();

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