import javax.swing.*;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.File;

class TableImage {

    public static void main(String[] args) throws Exception {
        Object[][] data = {
            {"Hari", new Integer(23), new Double(78.23), new Boolean(true)},
            {"James", new Integer(23), new Double(47.64), new Boolean(false)},
            {"Sally", new Integer(22), new Double(84.81), new Boolean(true)}
        };

        String[] columns = {"Name", "Age", "GPA", "Pass"};

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);

        scroll.setColumnHeaderView(table.getTableHeader());
        table.setPreferredScrollableViewportSize(table.getPreferredSize());

        JPanel p = new JPanel(new BorderLayout());
        p.add(scroll, BorderLayout.CENTER);

        BufferedImage bi = ScreenImage.createImage(p);

        JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(bi)));
        ImageIO.write(bi,"png",new File("table.png"));
    }
}