import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;

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

                JDesktopPane dp = new JDesktopPane() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(600, 600);
                    }
                };

                JInternalFrame inFrm = new JInternalFrame("Image", true, true, true, true);
                inFrm.add(new ShowImagePane());
                inFrm.pack();
                inFrm.setVisible(true);
                dp.add(inFrm);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(dp);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ShowImagePane extends JPanel {

        private JFileChooser fc;

        public ShowImagePane() {
            setLayout(new BorderLayout());
            ImagePane imagePane = new ImagePane();
            add(imagePane);
            JButton open = new JButton("Open...");
            open.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (fc == null) {
                        fc = new JFileChooser();
                        fc.addChoosableFileFilter(new FileFilter() {

                            @Override
                            public boolean accept(File f) {
                                String name = f.getName().toLowerCase();
                                return name.endsWith(".png")
                                                || name.endsWith(".jpg")
                                                || name.endsWith(".jpeg")
                                                || name.endsWith(".bmp");
                            }

                            @Override
                            public String getDescription() {
                                return "Images";
                            }
                        });
                        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        fc.setMultiSelectionEnabled(false);
                    }

                    switch (fc.showOpenDialog(ShowImagePane.this)) {
                        case JFileChooser.APPROVE_OPTION:
                            File selected = fc.getSelectedFile();
                            try {
                                imagePane.setImageSource(selected);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            break;
                    }
                }
            });
            add(open, BorderLayout.SOUTH);
        }

    }

    public class ImagePane extends JPanel {

        private BufferedImage bgImage;
        private Image scaled;

        public ImagePane(File source) throws IOException {
            setImageSource(source);
        }

        public ImagePane() {
        }

        @Override
        public void invalidate() {
            super.invalidate();
            resizeImage();
        }

        public void setImageSource(File source) throws IOException {
            if (source != null) {
                bgImage = ImageIO.read(source);
                resizeImage();
            } else {
                bgImage = null;
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return bgImage == null ? new Dimension(200, 200) : new Dimension(bgImage.getWidth(), bgImage.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (scaled != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                int x = (getWidth() - scaled.getWidth(this)) / 2;
                int y = (getHeight() - scaled.getHeight(this)) / 2;
                g2d.drawImage(scaled, x, y, this);
                g2d.dispose();
            }
        }

        protected void resizeImage() {
            if (bgImage != null) {
                if (getWidth() < getHeight()) {
                    scaled = bgImage.getScaledInstance(this.getWidth(), -1, Image.SCALE_SMOOTH);
                } else {
                    scaled = bgImage.getScaledInstance(-1, getHeight(), Image.SCALE_SMOOTH);
                }
                repaint();
            }
        }

    }

}