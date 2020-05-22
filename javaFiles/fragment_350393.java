import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CheckBoxMenuItemIconPosition {

    private JComponent ui = null;
    private JMenuBar mb = null;

    CheckBoxMenuItemIconPosition() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(40,160,40,160));
    }

    public JComponent getUI() {
        return ui;
    }

    public JMenuBar getMenuBar() {
        if (mb != null) return mb;

        mb = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        mb.add(fileMenu);

        BufferedImage bi = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
        JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem(
                "Text", new ImageIcon(bi));
        checkBoxMenuItem.setHorizontalTextPosition(SwingConstants.LEFT);
        fileMenu.add(checkBoxMenuItem);

        return mb;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                CheckBoxMenuItemIconPosition o = new CheckBoxMenuItemIconPosition();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.setJMenuBar(o.getMenuBar());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}