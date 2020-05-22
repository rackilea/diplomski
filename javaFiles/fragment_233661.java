import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Browser1 {
    private JTabbedPane tabbedPane;
    private final JButton add;
    int i = 1;

    public Browser1() {
        tabbedPane = new JTabbedPane();
        tabbedPane.add(new JScrollPane(createTabbedPanel()), "Tab " + i);

        add = new JButton("Add Tab");
        add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                i++;
                tabbedPane.add(new JScrollPane(createTabbedPanel()), "Tab " + i);
            }
        });

        JFrame frame = new JFrame("Browser");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        buttonPanel.add(add);
        frame.add(buttonPanel, BorderLayout.PAGE_START);
        frame.add(tabbedPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createTabbedPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextField field = new JTextField(50);
        JEditorPane pane = new JEditorPane();
        pane.setPreferredSize(new Dimension(700, 500));

        panel.add(field, BorderLayout.NORTH);
        panel.add(pane, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new Browser1();
            }
        });
    }
}