import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ContainerListener extends JFrame {

    private static final long serialVersionUID = 1L;

    public ContainerListener() {
        super("Test");
        setContentPane(new TestPanel());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] parameters) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ContainerListener containerListener = new ContainerListener();
            }
        });
    }

    private class TestPanel extends JPanel {

        private static final long serialVersionUID = 1L;

        TestPanel() {
            setLayout(new FlowLayout(FlowLayout.LEFT));
            add(new JButton(new AbstractAction("Add label") {

                private static final long serialVersionUID = 1L;
                private int n = 0;

                @Override
                public void actionPerformed(ActionEvent event) {
                    TestPanel.this.add(new JLabel("Label " + ++n));
                    validate();
                }
            }));
            addHierarchyListener(new HierarchyListener() {

                @Override
                public void hierarchyChanged(HierarchyEvent e) {
                    System.out.println("Components Change: " + e.getChanged());
                    if ((e.getChangeFlags() & HierarchyEvent.DISPLAYABILITY_CHANGED) != 0) {
                        if (e.getComponent().isDisplayable()) {
                            System.out.println("Components: " + e.getChanged());
                        } else {
                            System.out.println("Components: " + e.getChanged());
                        }
                    }
                }
            });
            addContainerListener(new ContainerAdapter() {

                @Override
                public void componentAdded(ContainerEvent event) {
                    System.out.println("componentAdded : " + event.getChild() + "containerName" + " was added");
                }
            });

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }
    }
}