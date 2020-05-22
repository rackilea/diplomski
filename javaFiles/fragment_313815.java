package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

/**
 * @see http://stackoverflow.com/questions/8507521
 * @see http://stackoverflow.com/questions/5129294
 */
public class ImageApp extends JPanel {

    private static final int MASK =
        Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
    private JFileChooser chooser = new JFileChooser();
    private Action openAction = new ImageOpenAction("Open");
    private Action clearAction = new ClearAction("Clear");
    private JPopupMenu popup = new JPopupMenu();
    private BufferedImage image;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ImageApp().create();
            }
        });
    }

    public void create() {
        JFrame f = new JFrame();
        f.setTitle("Title");
        f.add(new JScrollPane(this), BorderLayout.CENTER);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menu.setMnemonic('F');
        menu.add(new JMenuItem(openAction));
        menu.add(new JMenuItem(clearAction));
        menuBar.add(menu);
        f.setJMenuBar(menuBar);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setSize(new Dimension(640, 480));
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public ImageApp() {
        this.setComponentPopupMenu(popup);
        popup.add("Popup Menu");
        popup.add(new JMenuItem(openAction));
        popup.add(new JMenuItem(clearAction));
    }

    @Override
    public Dimension getPreferredSize() {
        if (image == null) {
            return new Dimension();
        } else {
            return new Dimension(image.getWidth(), image.getHeight());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    private class ClearAction extends AbstractAction {

        public ClearAction(String name) {
            super(name);
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(Action.ACCELERATOR_KEY,
                KeyStroke.getKeyStroke(KeyEvent.VK_C, MASK));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            image = null;
            revalidate();
            repaint();
        }
    }

    private class ImageOpenAction extends AbstractAction {

        public ImageOpenAction(String name) {
            super(name);
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_O);
            this.putValue(Action.ACCELERATOR_KEY,
                KeyStroke.getKeyStroke(KeyEvent.VK_O, MASK));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int returnVal = chooser.showOpenDialog(chooser);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File f = chooser.getSelectedFile();
                try {
                    image = ImageIO.read(f);
                    revalidate();
                    repaint();
                } catch (IOException ex) {
                    ex.printStackTrace(System.err);
                }
            }
        }
    }
}