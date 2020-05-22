import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class ZoomPanel extends JPanel implements Scrollable {

    private static final int DEFAULT_SIZE = 500;

    private float zoom = 1f;

    @Override
    public Dimension getPreferredSize() {
        int size = Math.round(zoom * DEFAULT_SIZE);
        return new Dimension(size, size);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int size = Math.round(zoom * DEFAULT_SIZE);
        g.drawOval(0, 0, size, size);
    }

    private static class ZoomRenderer extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Object val = value;
            if (value instanceof Number) {
                val = Math.round(((Number) value).doubleValue() * 100) + "%";
            }
            return super.getListCellRendererComponent(list, val, index, isSelected, cellHasFocus);
        }
    }

    public static void main(String[] args) {
        JFrame frm = new JFrame("Zoom panel");
        ZoomPanel z = new ZoomPanel();
        JScrollPane scroller = new JScrollPane(z);
        Float[] zooms = {.5f, .75f, 1f, 1.5f, 2f, 4f};
        JComboBox<Float> combo = new JComboBox<>(zooms);
        combo.setSelectedIndex(2);
        combo.setRenderer(new ZoomRenderer());
        combo.addActionListener(e -> {
            Float v = (Float) combo.getSelectedItem();
            if (v != null) {
                z.zoom = v;
                scroller.revalidate();
                scroller.repaint();
            }
        });
        JPanel comboPanel = new JPanel();
        comboPanel.add(combo);
        frm.add(comboPanel, BorderLayout.NORTH);
        frm.add(scroller);
        frm.pack();
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return getPreferredSize();
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 5;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 20;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return false;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }
}