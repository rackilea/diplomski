import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class OneLineCombo {

    private JComponent ui = null;

    OneLineCombo() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(4,20,4,20));

        String[] fontFamily = GraphicsEnvironment.
                getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        JComboBox fontCombo = new JComboBox(fontFamily);
        fontCombo.setMaximumRowCount(1);
        ui.add(fontCombo, BorderLayout.PAGE_START);
        ui.add(new JLabel("Type some letters of the font name to select it"), 
                BorderLayout.PAGE_END);
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
                OneLineCombo o = new OneLineCombo();

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