import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TestTabSelection {

    public static void main(String[] args) {
        new TestTabSelection();
    }

    public TestTabSelection() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                final JTabbedPane tab = new JTabbedPane();
                tab.addTab("A", new JPanel());
                tab.addTab("+", new JPanel());
                tab.getModel().addChangeListener(new ChangeListener() {
                    private int lastSelected;
                    private boolean ignore = false;

                    @Override
                    public void stateChanged(ChangeEvent e) {
                        if (!ignore) {
                            ignore = true;
                            try {
                                int selected = tab.getSelectedIndex();
                                String title = tab.getTitleAt(selected);
                                if ("+".equals(title)) {
                                    JPanel pane = new JPanel();
                                    tab.insertTab("Tab" + (tab.getTabCount() - 1), null, pane, null, lastSelected + 1);
                                    tab.setSelectedComponent(pane);
                                } else {
                                    lastSelected = selected;
                                }
                            } finally {
                                ignore = false;
                            }
                        }
                    }
                });
                final JButton btn = new JButton("Add");
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(tab.getTabCount());
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(tab);
                frame.add(btn, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}