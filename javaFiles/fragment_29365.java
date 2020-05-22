import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Test4 {

    protected static void initUI() {
        JFrame frame = new JFrame("test");
        frame.setBounds(0, 0, 300, 200);
        frame.setVisible(true);
        System.err.println(frame.getSize());
        frame.setResizable(false);
        System.err.println(frame.getSize());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                initUI();
            }
        });
    }
}