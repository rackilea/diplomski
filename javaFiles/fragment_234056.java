import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class TestPrint {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestPrint().run();
            }
        });
    }

    protected void run() {
        JTable table = new JTable(new Vector<Vector<Object>>(), new Vector<String>(Arrays.asList("Hello", "World")));
        int column = 1;
        Component component = table.getTableHeader().getDefaultRenderer()
                .getTableCellRendererComponent(table, table.getColumnName(column), false, false, -1, column);
        component.setBounds(0, 0, table.getColumnModel().getColumn(0).getWidth(), table.getRowHeight());
        BufferedImage img = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.setColor(component.getForeground());
        g.setFont(component.getFont());
        component.paint(g);
        JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)), "Test", JOptionPane.INFORMATION_MESSAGE, null);
        System.exit(0);
    }
}