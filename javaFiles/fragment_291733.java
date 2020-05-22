import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.*;
import javax.swing.table.*;

import java.io.*;
import java.net.URL;

class ImageBrightnessFilter {

    BufferedImage bi;
    JPanel gui = null;
    ArrayList<Point> points;
    JLabel l;

    ImageBrightnessFilter(BufferedImage bi) {
        this.bi = bi;
    }

    public static double getNeighborDifference(BufferedImage bi, int x, int y) {
        Color c = new Color(bi.getRGB(x, y));
        int r = c.getRed();

        int tot = 0;
        for (int xx = x - 1; xx < x + 2; xx++) {
            for (int yy = y - 1; yy < y + 2; yy++) {
                try {
                    tot += new Color(bi.getRGB(xx, yy)).getRed();
                } catch (ArrayIndexOutOfBoundsException aioobe) {
                    tot += r;
                }
            }
        }

        return (tot / 8d) - r;
    }

    public JPanel getGui() {
        if (gui == null) {
            gui = new JPanel(new BorderLayout(2, 2));

            ImageTableModel itm = new ImageTableModel(bi);
            final JTable table = new JTable(itm);
            table.setAutoCreateRowSorter(true);
            JScrollPane tableScroll = new JScrollPane(table);
            Dimension d = tableScroll.getPreferredSize();
            Dimension shortTable = new Dimension(
                    (int) d.getWidth(),
                    table.getRowHeight() * 8
                    + table.getTableHeader().getPreferredSize().height);
            tableScroll.setPreferredSize(shortTable);
            gui.add(tableScroll, BorderLayout.CENTER);

            l = new JLabel(
                    new ImageIcon(
                    (bi.getSubimage(0, 0, 80, 40)).getScaledInstance(640, 320, 0)));
            l.setBorder(new LineBorder(Color.BLACK));
            gui.add(l, BorderLayout.PAGE_START);

            ListSelectionListener lsl = new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    points = new ArrayList<Point>();
                    if (!e.getValueIsAdjusting()) {
                        int[] rows = table.getSelectedRows();
                        for (int row : rows) {
                            int index = row;
                            int x = (Integer) table.getValueAt(index, 0);
                            int y = (Integer) table.getValueAt(index, 1);
                            Point p = new Point(x, y);
                            points.add(p);
                        }
                    }
                    l.setIcon(new ImageIcon(getHighlightImage().getScaledInstance(640, 320, 0)));
                    l.repaint();
                }
            };
            table.getSelectionModel().addListSelectionListener(lsl);

            JToolBar tb = new JToolBar();
            gui.add(tb, BorderLayout.PAGE_END);
            JButton saveImage = new JButton("Save");
            tb.add(saveImage);
            ActionListener saveListener = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = JOptionPane.showInputDialog(gui, "name");
                    File home = new File(System.getProperty("user.home"));
                    File f = new File(home,s + ".png");
                    try {
                        ImageIO.write(getHighlightImage(), "png", f);
                    } catch (IOException ex) {
                        Logger.getLogger(
                                ImageBrightnessFilter.class.getName()).log(
                                Level.SEVERE, null, ex);
                    }
                }
            };
            saveImage.addActionListener(saveListener);
        }

        return gui;

    }

    public BufferedImage getHighlightImage() {
        BufferedImage b = new BufferedImage(
                bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = b.createGraphics();
        g.drawImage(bi, 0, 0, null);

        g.setColor(new Color(0, 255, 0, 95));
        if (points!=null) {
            for (Point point : points) {
                g.drawLine(point.x - 4, point.y, point.x - 2, point.y);
                g.drawLine(point.x + 4, point.y, point.x + 2, point.y);
                g.drawLine(point.x, point.y - 4, point.x, point.y - 2);
                g.drawLine(point.x, point.y + 4, point.x, point.y + 2);
            }
        }

        g.dispose();

        return b;
    }

    public static void main(String[] args) throws Exception {
        String s = "I:\\pics\\Space\\Stellar\\2\\MarsSthHemisphereInSpring.gif";
        File f = new File(s);
        URL url = new URL("http://i.stack.imgur.com/z8U5w.png");
        BufferedImage bi0 =
            //ImageIO.read(f);
            ImageIO.read(url);
        final BufferedImage bi =
            //bi0.getSubimage(160, 799, 80, 40);
            bi0;
        Runnable r = new Runnable() {

            @Override
            public void run() {
                ImageBrightnessFilter ibf = new ImageBrightnessFilter(bi);
                JOptionPane.showMessageDialog(null, ibf.getGui());
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

class ImageTableModel extends DefaultTableModel {

    BufferedImage bi;
    final static String[] columnName = {
        "X",
        "Y",
        "RGB",
        "Diff"
    };

    public ImageTableModel(BufferedImage bi) {
        super();
        this.bi = bi;
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        Object o = null;
        int x = rowIndex % bi.getWidth();
        int y = rowIndex / bi.getWidth();
        int rgb = bi.getRGB(x, y);
        Color c = new Color(rgb);
        int r = c.getRed();
        switch (columnIndex) {
            case 0:
                o = new Integer(x);
                break;
            case 1:
                o = new Integer(y);
                break;
            case 2:
                o = new Integer(r);
                break;
            case 3:
                o = new Double(ImageBrightnessFilter.getNeighborDifference(
                        bi, x, y));
                break;
            default:
                return null;
        }
        return o;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 1:
            case 2:
                return Integer.class;
            case 3:
                return Double.class;
            default:
                return null;
        }
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnName[columnIndex];
    }

    @Override
    public int getRowCount() {
        if (bi == null) {
            return 80 * 40;
        }
        return bi.getHeight() * bi.getWidth();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}