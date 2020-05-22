package com.ggl.testing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CanvasFrame extends JPanel {

    private static final long serialVersionUID = -2454929744982913302L;

    private List<Point> location = new ArrayList<Point>();

    public CanvasFrame() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                location.clear();
                location.add(e.getPoint());
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                location.add(e.getPoint());
                repaint();
            }
        });

        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (location.size() <= 0) {
            return;
        }

        Point p = location.get(0);
        for (int i = 1; i < location.size(); i++) {
            Point q = location.get(i);
            g.drawLine(p.x, p.y, q.x, q.y);
            p = q;
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Drawing with friends");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new CanvasFrame(), BorderLayout.CENTER);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        };
        SwingUtilities.invokeLater(runnable);
    }
}