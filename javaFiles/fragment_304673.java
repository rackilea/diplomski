import java.awt.ComponentOrientation;
import javax.swing.JFrame;
import javax.swing.UIManager;
import org.pushingpixels.substance.api.skin.SubstanceOfficeSilver2007LookAndFeel;

public class RightToLeft {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    UIManager.setLookAndFeel(new SubstanceOfficeSilver2007LookAndFeel());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JFrame.setDefaultLookAndFeelDecorated(true);
                JFrame frame = new JFrame("العنوان بالعربي");
                frame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                frame.setSize(300, 300);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    private RightToLeft() {
    }
}