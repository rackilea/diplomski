import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JPanelsInsideJScrollPane {

    private JFrame frame = new JFrame("JPanels Inside JScrollPane");
    private JScrollPane scrollPane = new JScrollPane();
    private JPanel parentPanel, childOne, childTwo, childThree;
    private JButton button = new JButton("Change, Switch Layout Manager to BoxLayout");

    public JPanelsInsideJScrollPane() {
        parentPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(new Dimension(800, 600));
            }

            @Override
            public void paintComponent(Graphics g) {
                int margin = 10;
                Dimension dim = getSize();
                super.paintComponent(g);
                g.setColor(Color.DARK_GRAY);
                g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
            }
        };
        parentPanel.setLayout(new GridLayout(0, 1));
        childOne = new JPanel() {
            @Override
            public Dimension getMinimumSize() {
                return new Dimension(100, 100);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 300);
            }

            @Override
            public Dimension getMaximumSize() {
                return new Dimension(500, 300);
            }

            @Override
            public void paintComponent(Graphics g) {
                int margin = 10;
                Dimension dim = getSize();
                super.paintComponent(g);
                g.setColor(Color.GREEN);
                g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
            }
        };
        childTwo = new JPanel() {
            @Override
            public Dimension getMinimumSize() {
                return new Dimension(100, 100);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 300);
            }

            @Override
            public Dimension getMaximumSize() {
                return new Dimension(600, 400);
            }

            @Override
            public void paintComponent(Graphics g) {
                int margin = 10;
                Dimension dim = getSize();
                super.paintComponent(g);
                g.setColor(Color.BLUE);
                g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
            }
        };
        childThree = new JPanel() {
            @Override
            public Dimension getMinimumSize() {
                return new Dimension(100, 100);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 300);
            }

            @Override
            public Dimension getMaximumSize() {
                return new Dimension(800, 600);
            }

            @Override
            public void paintComponent(Graphics g) {
                int margin = 10;
                Dimension dim = getSize();
                super.paintComponent(g);
                g.setColor(Color.ORANGE);
                g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
            }
        };
        parentPanel.add(childOne);
        parentPanel.add(childTwo);
        parentPanel.add(childThree);
        scrollPane.setViewportView(parentPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LayoutManager manager = parentPanel.getLayout();
                if ((manager != null) && (manager instanceof BoxLayout)) {
                    parentPanel.setLayout(new GridLayout(0, 1));
                    button.setText("Change, Switch Layout Manager to BoxLayout");
                } else if ((manager != null) && (manager instanceof GridLayout)) {
                    parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.PAGE_AXIS));
                    button.setText("Change, Switch Layout Manager to GridLayout");
                }
                parentPanel.revalidate();
                parentPanel.repaint();
            }
        });
        frame.add(scrollPane);
        frame.add(button, BorderLayout.SOUTH);
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JPanelsInsideJScrollPane();
            }
        });
    }
}