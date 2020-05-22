import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListTest {


    private static void createAndShowGui() {
        final JFrame frame = new JFrame("JList Test");
        final JPanel panel = new JPanel();

        String[] listData = {"One", "Two", "Three", "Four", "Five", "Six"};
        final JList<String> list = new JList<>(listData);
        // list.setOpaque(false);
        list.setBackground(new Color(0, 0, 0, 0));
        list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                panel.repaint();
            }
        });

        panel.add(list);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}