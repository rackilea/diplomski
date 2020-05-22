import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.*;

public class ChooserInCurrentDir {

    // the GUI as seen by the user (without frame)
    JPanel gui = new JPanel(new BorderLayout());
    JFileChooser fileChooser;
    private JTextArea output = new JTextArea(10, 40);

    ChooserInCurrentDir() {
        initComponents();
    }

    public final void initComponents() {
        gui.setBorder(new EmptyBorder(2, 3, 2, 3));

        String userDirLocation = System.getProperty("user.dir");
        File userDir = new File(userDirLocation);
        // default to user directory
        fileChooser = new JFileChooser(userDir);

        Action open = new AbstractAction("Open") {

            @Override
            public void actionPerformed(ActionEvent e) {
                int result = fileChooser.showOpenDialog(gui);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        File f = fileChooser.getSelectedFile();
                        FileReader fr = new FileReader(f);
                        output.read(fr, f);
                        fr.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };

        Action save = new AbstractAction("Save") {

            @Override
            public void actionPerformed(ActionEvent e) {
                int result = fileChooser.showSaveDialog(gui);
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };

        JToolBar tb = new JToolBar();
        gui.add(tb, BorderLayout.PAGE_START);
        tb.add(open);
        tb.add(save);

        output.setWrapStyleWord(true);
        output.setLineWrap(true);

        gui.add(new JScrollPane(
                output,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
    }

    public final JComponent getGui() {
        return gui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                ChooserInCurrentDir cicd = new ChooserInCurrentDir();
                JFrame f = new JFrame("Chooser In Current Dir");
                f.add(cicd.getGui());
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See http://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // should be done last, to avoid flickering, moving,
                // resizing artifacts.
                f.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}