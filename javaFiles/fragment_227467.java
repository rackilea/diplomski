import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ImageWalker extends JPanel {

    public static void main(String[] args) {
        new ImageWalker();
    }

    public ImageWalker() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new MyPanel());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MyPanel extends JPanel {

        public Image walkable;
        private int i = 0;
        private File[] listOfFiles;

        public MyPanel() {

            String path = ".";
            File folder = new File(path);
            listOfFiles = folder.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    String name = pathname.getName().toLowerCase();
                    return name.endsWith("png") || name.endsWith("jpg");
                }
            });

            if (listOfFiles != null && listOfFiles.length > 0) {
                loadCurrent();
            }

            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "next");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");

            am.put("next", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (listOfFiles != null && listOfFiles.length > 0) {
                        i--;
                        if (i < 0) {
                            i = listOfFiles.length - 1;
                        }
                        loadCurrent();
                    }
                }
            });
            am.put("right", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (listOfFiles != null && listOfFiles.length > 0) {
                        i++;
                        if (i >= listOfFiles.length) {
                            i = 0;
                        }
                        loadCurrent();
                    }
                }
            });

        }

        protected void loadCurrent() {

            if (listOfFiles != null && listOfFiles.length > 0) {
                File file = listOfFiles[i];
                try {
                    walkable = ImageIO.read(file);
                    repaint();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(walkable, 0, 0, this);
        }
    }
}