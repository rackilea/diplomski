import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/** @see http://stackoverflow.com/questions/8955638 */
public class NewMain {

    public static void main(String[] args) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty(
            "com.apple.mrj.application.apple.menu.about.name", "Name");
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                JFrame frame = new JFrame("Gabby");
                final JPanel dm = new JPanel() {

                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(320, 240);
                    }
                };
                dm.setBorder(BorderFactory.createLineBorder(Color.blue, 10));

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(dm);
                frame.pack();
                frame.setLocationByPlatform(true);

                JMenuBar menuBar = new JMenuBar();
                JMenu fileMenu = new JMenu("File");
                menuBar.add(fileMenu);
                frame.setJMenuBar(menuBar);
                frame.setVisible(true);
            }
        });
    }
}