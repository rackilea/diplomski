import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

public class NestedLayout {

    private JFrame frame = new JFrame();
    private JPanel leftPanel = new JPanel();

    public NestedLayout() {
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createEmptyBorder(
                10, //top
                10, //left
                10, //bottom
                10));   //right
        leftPanel.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.CENTER);
        leftPanel.setPreferredSize(new Dimension(40, 40));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(leftPanel, BorderLayout.WEST);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new NestedLayout();
            }
        });
    }
}