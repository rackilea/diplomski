import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import java.net.*;
import java.util.*;
import javax.imageio.ImageIO;

public class HueSort {

    private JComponent ui = null;
    BufferedImage[] images;

    HueSort() throws Exception {
        initUI();
    }

    public void initUI() throws Exception {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        String[] paths = {
            "http://i.stack.imgur.com/wCF8S.png",
            "http://i.stack.imgur.com/T5uTa.png",
            "http://i.stack.imgur.com/IHARa.png"
        };
        BufferedImage[] images = new BufferedImage[3];
        for (int i = 0; i < paths.length; i++) {
            images[i] = ImageIO.read(new URL(paths[i]));
        }
        Random rand = new Random();
        String[] headers = {
            "Image", "Image", "Image", "Image", "Image", "Image", "Image"
        };
        BufferedImage[][] tableImages = new BufferedImage[11][headers.length];
        for (int r = 0; r < tableImages.length; r++) {
            for (int c = 0; c < tableImages[0].length; c++) {
                int index = rand.nextInt(images.length);
                tableImages[r][c] = images[index];
            }
        }
        TableCellRenderer tcr = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                Component c = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
                if (c instanceof JLabel) {
                    Image image = (Image) value;
                    JLabel l = (JLabel) c;
                    l.setText("");
                    l.setIcon(new ImageIcon(image));
                }
                return c;
            }
        };
        JTable table = new JTable(tableImages, headers) {
            @Override
            public Class getColumnClass(int column) {
                return Image.class;
            }
        };
        table.setAutoCreateRowSorter(true);
        table.setDefaultRenderer(Image.class, tcr);
        table.setRowHeight(34);
        ui.add(new JScrollPane(table));
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                HueSort o;
                try {
                    o = new HueSort();
                    JFrame f = new JFrame("Hue Sort");
                    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    f.setLocationByPlatform(true);

                    f.setContentPane(o.getUI());
                    f.pack();
                    f.setMinimumSize(f.getSize());

                    f.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        SwingUtilities.invokeLater(r);
    }
}