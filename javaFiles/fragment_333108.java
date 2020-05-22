import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class MyFrame {

    private JFrame frame = new JFrame();
    private JPanel panel;

    public MyFrame() {
        frame.add(getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                System.out.println("Window Resized: Frame");
            }
        });
    }

    public JPanel getPanel() {
        if (panel == null) {
            panel = new JPanel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(300, 200);
                }
            };
            panel.setBackground(Color.RED);
        }
        return panel;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame app = new MyFrame();
            }
        });
    }
}