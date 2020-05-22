package com.ggl.testing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class MyFrame implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LinePanel linePanel = new LinePanel();
        setKeyBindings(linePanel);
        frame.add(linePanel);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private void setKeyBindings(LinePanel linePanel) {
        InputMap inputMap = linePanel
                .getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke("W"), "up arrow");
        inputMap.put(KeyStroke.getKeyStroke("S"), "down arrow");
        inputMap.put(KeyStroke.getKeyStroke("A"), "left arrow");
        inputMap.put(KeyStroke.getKeyStroke("D"), "right arrow");

        inputMap.put(KeyStroke.getKeyStroke("UP"), "up arrow");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "down arrow");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "left arrow");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "right arrow");

        inputMap = linePanel.getInputMap(JPanel.WHEN_FOCUSED);
        inputMap.put(KeyStroke.getKeyStroke("UP"), "up arrow");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "down arrow");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "left arrow");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "right arrow");

        linePanel.getActionMap().put("up arrow", new UpArrowAction(linePanel));
        linePanel.getActionMap().put("down arrow",
                new DownArrowAction(linePanel));
        linePanel.getActionMap().put("left arrow",
                new LeftArrowAction(linePanel));
        linePanel.getActionMap().put("right arrow",
                new RightArrowAction(linePanel));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new MyFrame());
    }

    public class LinePanel extends JPanel {

        private static final long serialVersionUID = 2504617322590404776L;

        private Point lastPoint;

        private Polygon points;

        public LinePanel() {
            this.setPreferredSize(new Dimension(400, 400));
            this.lastPoint = new Point(200, 200);
            this.points = new Polygon();
            this.points.addPoint(200, 200);
        }

        public void addPoint(int x, int y) {
            lastPoint = new Point(x, y);
            points.addPoint(x, y);
        }

        public Point getPreviousPoint() {
            return lastPoint;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawPolyline(points.xpoints, points.ypoints, points.npoints);
        }
    }

    public class UpArrowAction extends AbstractAction {

        private static final long serialVersionUID = 8463453082541763265L;

        private LinePanel linePanel;

        public UpArrowAction(LinePanel linePanel) {
            this.linePanel = linePanel;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            Point p = linePanel.getPreviousPoint();
            p.y -= 10;
            linePanel.addPoint(p.x, p.y);
            linePanel.repaint();
        }

    }

    public class DownArrowAction extends AbstractAction {

        private static final long serialVersionUID = 3619846728122990617L;

        private LinePanel linePanel;

        public DownArrowAction(LinePanel linePanel) {
            this.linePanel = linePanel;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            Point p = linePanel.getPreviousPoint();
            p.y += 10;
            linePanel.addPoint(p.x, p.y);
            linePanel.repaint();
        }

    }

    public class LeftArrowAction extends AbstractAction {

        private static final long serialVersionUID = -2772213334907267331L;

        private LinePanel linePanel;

        public LeftArrowAction(LinePanel linePanel) {
            this.linePanel = linePanel;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            Point p = linePanel.getPreviousPoint();
            p.x -= 10;
            linePanel.addPoint(p.x, p.y);
            linePanel.repaint();
        }

    }

    public class RightArrowAction extends AbstractAction {

        private static final long serialVersionUID = 8463453082541763265L;

        private LinePanel linePanel;

        public RightArrowAction(LinePanel linePanel) {
            this.linePanel = linePanel;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            Point p = linePanel.getPreviousPoint();
            p.x += 10;
            linePanel.addPoint(p.x, p.y);
            linePanel.repaint();
        }

    }
}