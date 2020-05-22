import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Example {

    public Example() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        DefaultListModel<String> listModel = new DefaultListModel<String>();
        JList<String> list = new JList<String>(listModel);
        list.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));

        JPanel panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 400);
            }
            // Uncomment the following lines if you also want to prevent the
            // 'wrapping' of the panel.
            /*
             * @Override public Dimension getMinimumSize() { return new
             * Dimension(400, 400); }
             */
        };
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        for (int i = 1; i <= 5; i++) {
            menuBar.add(new JMenu("Menu " + i));
            listModel.addElement("Element " + i);
            panel.add(new JLabel("Label " + i));
        }

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(panel);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(menuBar, BorderLayout.NORTH);
        contentPanel.add(list, BorderLayout.WEST);
        contentPanel.add(centerPanel);

        JFrame frame = new JFrame();
        frame.setContentPane(contentPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example();
            }
        });
    }

}