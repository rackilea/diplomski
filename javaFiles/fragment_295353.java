import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;

/** @see https://stackoverflow.com/questions/6309407 */
public class DialogClose extends JDialog {

    public DialogClose(int i) {
        this.setTitle("Dialog " + String.valueOf(i));
        this.setPreferredSize(new Dimension(320, 200));
    }

    private void display() {
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        passSomeTime();
        this.setVisible(false);
        this.dispatchEvent(new WindowEvent(
            this, WindowEvent.WINDOW_CLOSING));
        this.dispose();
        passSomeTime();
    }

    private void passSomeTime() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ie) {
            ie.printStackTrace(System.err);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                int count = 0;
                while (true) {
                    new DialogClose(count++).display();
                }
            }
        });
    }
}