import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestInternalFrameLayout {

    public static void main(String[] args) {
        new TestInternalFrameLayout();
    }

    public TestInternalFrameLayout() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final JDesktopPane desktop = new JDesktopPane();

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(desktop);
                frame.setSize(420, 420);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        int rowCount = 2;
                        int colCount = 4;

                        int width = desktop.getWidth() / colCount;
                        int height = desktop.getHeight() / rowCount;

                        System.out.println(width + "x" + height);

                        for (int row = 0; row < rowCount; row++) {
                            int y = row * height;
                            for (int col = 0; col < colCount; col++) {
                                int x = col * width;
                                JInternalFrame frame = new JInternalFrame(row + "x" + col, true, true, true, true);
                                frame.setBounds(x, y, width, height);
                                frame.setVisible(true);
                                desktop.add(frame);
                            }
                        }
                    }
                });
            }
        });
    }
}