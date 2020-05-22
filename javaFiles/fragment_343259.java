import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MainClass {

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            "org.pushingpixels.substance.api.skin.SubstanceOfficeBlue2007LookAndFeel");
                    //UIManager.getDefaults();
                } catch (Exception e) {
                }
            }
        });

       /*try {
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(laf.getName())) {
                    UIManager.setLookAndFeel(laf.getClassName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame("JToggleButton Sample");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());
                panel.add(new JToggleButton("North"), BorderLayout.NORTH);
                panel.add(new JToggleButton("East"), BorderLayout.EAST);
                panel.add(new JToggleButton("West"), BorderLayout.WEST);
                panel.add(new JToggleButton("Center"), BorderLayout.CENTER);
                panel.add(new JToggleButton("South"), BorderLayout.SOUTH);
                f.add(panel);
                f.pack();
                //f.setSize(300, 200);
                f.setVisible(true);
            }
        });
    }
}