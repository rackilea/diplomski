import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ButtonColumnLayout {

    private JComponent ui = null;
    String[] labels = {"Start", "Stop", "Quit"};
    // adjust numbers to change spacing between button text and button edge
    Insets insets = new Insets(10,40,10,40);

    ButtonColumnLayout() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        // adjust last two numbers to change spacing between buttons
        ui = new JPanel(new GridLayout(0, 1, 10, 10));
        // adjust numbers to change border around buttons
        ui.setBorder(new EmptyBorder(40,100,40,100));

        for (String s : labels) {
            ui.add(getBigButton(s));
        }
    }

    private final JButton getBigButton(String text) {
        JButton b = new JButton(text);
        // adjust float value to change font size
        b.setFont(b.getFont().deriveFont(25f));
        b.setMargin(insets);

        return b;
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
                ButtonColumnLayout o = new ButtonColumnLayout();

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