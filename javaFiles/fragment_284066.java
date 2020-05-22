import java.awt.*;
import javax.swing.*;
import javax.swing.colorchooser.*;
import javax.swing.border.*;

class ColorChooserTest2 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JColorChooser cc = new JColorChooser();
                AbstractColorChooserPanel[] panels = cc.getChooserPanels();

                JPanel p = new JPanel();
                panels[1].setBorder(
                    new TitledBorder(panels[1].getDisplayName()));
                p.add(panels[1]);

                panels[2].setBorder(
                    new TitledBorder(panels[2].getDisplayName()));
                p.add(panels[2]);

                JPanel gui = new JPanel(new BorderLayout(2,2));
                gui.add(p, BorderLayout.CENTER);

                gui.add(cc.getPreviewPanel(), BorderLayout.SOUTH);

                JOptionPane.showMessageDialog(null, gui);
            }
        });
    }
}