import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ThreeSizeGui {

    public static void swapComponentsAndResizeUI(
            JComponent ui, 
            JComponent current,
            JComponent next) {
        ui.remove(current);
        ui.add(next);
        current = next;
        Component c = ui.getTopLevelAncestor();
        if (c instanceof Window) {
            Window w = (Window) c;
            w.pack();
        }
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                final JPanel ui = new JPanel(new BorderLayout(4, 4));
                ui.setBorder(new EmptyBorder(6, 6, 6, 6));

                JPanel controls = new JPanel(
                        new FlowLayout(FlowLayout.LEADING));
                ui.add(controls, BorderLayout.PAGE_START);
                int s = 100;
                Dimension[] sizes = {
                    new Dimension(s * 4, s * 2),
                    new Dimension(s * 6, s * 3),
                    new Dimension(s * 8, s * 4)
                };
                final JComboBox cb = new JComboBox(sizes);
                controls.add(cb);
                final JPanel[] panels = new JPanel[sizes.length];
                for (int ii = 0; ii < sizes.length; ii++) {
                    Dimension d = sizes[ii];
                    BufferedImage bi = new BufferedImage(
                            d.width, d.height, BufferedImage.TYPE_INT_RGB);
                    JPanel p = new JPanel(new GridLayout());
                    JLabel l = new JLabel(new ImageIcon(bi));
                    p.add(l);
                    panels[ii] = p;
                }
                ItemListener sizeListener = new ItemListener() {

                    JPanel current = panels[0];

                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        JPanel next = panels[cb.getSelectedIndex()];
                        swapComponentsAndResizeUI(ui, current, next);
                        current = next;
                    }
                };
                cb.addItemListener(sizeListener);

                ui.add(panels[0], BorderLayout.CENTER);

                JFrame f = new JFrame("Three Sized Panels");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setContentPane(ui);
                f.pack();
                f.setLocationByPlatform(true);
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}