package com.ggl.testing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CirclePaintTest implements Runnable {

    private JFrame frame;

    private PaintPanel paintPanel;

    @Override
    public void run() {
        frame = new JFrame("Circle Paint Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        paintPanel = new PaintPanel();
        mainPanel.add(paintPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton lineButton = new JButton("Draw Lines");
        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (paintPanel.isComplete()) {
                    paintPanel.setDrawLines(true);
                    paintPanel.repaint();
                }
            }
        });
        buttonPanel.add(lineButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new CirclePaintTest());
    }

    public class PaintPanel extends JPanel {

        private static final long serialVersionUID = 6481890334304291711L;

        private final Color[] colors = { Color.RED, Color.GREEN, Color.BLUE,
                Color.ORANGE, Color.CYAN, Color.YELLOW };

        private boolean drawLines;

        private final int pointLimit;

        private final List<Point> points;

        public PaintPanel() {
            this.points = new ArrayList<Point>();
            this.pointLimit = 3;
            this.drawLines = false;

            this.addMouseListener(new CircleMouseListener());
            this.setPreferredSize(new Dimension(400, 400));
        }

        public void setDrawLines(boolean drawLines) {
            this.drawLines = drawLines;
        }

        public boolean isComplete() {
            return points.size() >= pointLimit;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Point pp = null;
            Point p0 = null;

            for (int i = 0; i < points.size(); i++) {
                g.setColor(colors[i]);

                Point p = points.get(i);
                g.fillOval(p.x - 20, p.y - 20, 40, 40);

                pp = p;
            }

            if (drawLines && (points.size() > 1)) {
                p0 = points.get(0);
                pp = p0;
                g.setColor(Color.BLACK);
                for (int i = 1; i < points.size(); i++) {
                    Point p = points.get(i);
                    g.drawLine(pp.x, pp.y, p.x, p.y);
                    pp = p;
                }
                g.drawLine(pp.x, pp.y, p0.x, p0.y);
            }
        }

        public class CircleMouseListener extends MouseAdapter {

            @Override
            public void mousePressed(MouseEvent event) {
                if (points.size() < pointLimit) {
                    points.add(event.getPoint());
                    PaintPanel.this.repaint();
                }
            }
        }
    }

}