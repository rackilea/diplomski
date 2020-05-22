import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {

    private static final String PANEL_A = "panelA";
    private static final String PANEL_B = "panelB";

    CardLayout layout = new CardLayout();
    JPanel panel = new JPanel(layout);
    ComponentListenerPanel p1 = new ComponentListenerPanel(PANEL_A);
    ComponentListenerPanel p2 = new ComponentListenerPanel(PANEL_B);
    JButton b1 = new JButton(PANEL_A);
    JButton b2 = new JButton(PANEL_B);

    public Main() {
        panel.add(p1, PANEL_A);
        panel.add(p2, PANEL_B);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                show(PANEL_A);
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                show(PANEL_B);
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(b1);
        buttonPanel.add(b2);

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.add(buttonPanel, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void show(String panelName) {
        layout.show(panel, panelName);
    }

    private class ComponentListenerPanel extends JPanel {
        private String panelName;

        public ComponentListenerPanel(String panelName) {
            this.panelName = panelName;
            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentHidden(ComponentEvent evt) {
                    stop();
                }
                @Override
                public void componentShown(ComponentEvent evt) {
                    start();
                }
            });
        }

        public void start() {
            System.out.println(panelName + " started");
        }

        public void stop() {
            System.out.println(panelName + " stopped");
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}