import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class WhereAmI {

    public static void main(String[] args) {
        new WhereAmI();
    }

    public WhereAmI() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                try {
                    String path = new File(".").getCanonicalPath();
                    JOptionPane.showMessageDialog(null, "I was started in " + path);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }

            }
        });
    }

}