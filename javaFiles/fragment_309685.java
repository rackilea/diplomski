package sof;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.AbstractBorder;

public class NestedPanels {
    private JFrame frame;
    private JPanel outerPane;
    private JPanel innerPane;
    private GridBagConstraints gbc;
    private JScrollPane scrollPane;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new NestedPanels()::createAndShowGui);
    }

    private void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());

        outerPane = new JPanel();
        outerPane.setLayout(new GridLayout(0, 1, 5, 5));

        for (int i = 0; i < 5; i++) {
            innerPane = new JPanel();
            innerPane.setLayout(new GridBagLayout());

            gbc = new GridBagConstraints();

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(10, 10, 10, 10);

            innerPane.add(new JLabel("Recurring JLabel1"), gbc);

            gbc.gridx++;
            innerPane.add(new JLabel("Recurring JLabel2"), gbc);
            gbc.gridx++;
            innerPane.add(new JLabel("Recurring JLabel3"), gbc);
            gbc.gridx++;
            innerPane.add(new JButton("Recurring JButton1"), gbc);

            innerPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            outerPane.add(innerPane);
        }
        outerPane.setBorder(new CustomBorder(5, Color.BLACK));

        scrollPane = new JScrollPane(outerPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @SuppressWarnings("serial")
    class CustomBorder extends AbstractBorder {
        private int gap;
        private Color color;
        public CustomBorder(int gap, Color color) {
            this.gap = gap;
            this.color = color;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(gap, gap, gap, gap);
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(color);
            g2d.draw(new Rectangle2D.Double(x, y, width - 1, height - 1));
        }
    }
}