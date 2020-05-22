import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
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
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTable table = new JTable(new Vector<Vector<Object>>(), new Vector<String>(Arrays.asList("Hello", "World")));
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
        int column = 1;
        Rectangle headerRect = table.getTableHeader().getHeaderRect(column);
        BufferedImage img = new BufferedImage(headerRect.width, headerRect.height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.translate(-headerRect.width, 0);
        table.getTableHeader().print(g);
        frame.add(new JLabel(new ImageIcon(img)), BorderLayout.SOUTH);
        frame.pack();
    }
}