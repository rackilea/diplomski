package javaapplication1.pkg295;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new TestPane());

                DefaultListModel model = new DefaultListModel();
                model.addElement("Apple");
                model.addElement("Banana");
                model.addElement("Pear");
                model.addElement("Peach");
                model.addElement("Grap");
                JList list = new JList(model);
                list.setCellRenderer(new TransparentListCellRenderer());
                list.setOpaque(false);
                JScrollPane sp = new JScrollPane(list);
                sp.setOpaque(false);
                sp.getViewport().setOpaque(false);

                frame.add(sp);

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TransparentListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            setForeground(Color.WHITE);
            setOpaque(isSelected);
            return this;
        }

    }

    public class TestPane extends JPanel {

        private BufferedImage bgImg;

        public TestPane() {
            setLayout(new BorderLayout());
            try {
                bgImg = ImageIO.read(new File("C:\\Users\\shane\\Dropbox\\MegaTokyo\\Aqua\\200x200\\aria_manga_wallpaper-5541.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return bgImg == null ? new Dimension(200, 200) : new Dimension(bgImg.getWidth(), bgImg.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (bgImg != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                int x = (getWidth() - bgImg.getWidth()) / 2;
                int y = (getHeight() - bgImg.getHeight()) / 2;
                g2d.drawImage(bgImg, x, y, this);
                g2d.dispose();
            }
        }

    }

}