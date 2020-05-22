import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class DrawingUndo {

    List<Shape> shapes = new ArrayList<>();

    public DrawingUndo() {

        final Random randomizer = new Random();

        JFrame frame = new JFrame("Undoable drawings");

        JToolBar bar = new JToolBar();

        final JPanel undoPanel = new UndoPanel();

        JButton addRectangleButton = new JButton("Rectangle");
        addRectangleButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                int randomX = 5 + randomizer.nextInt(100);
                int randomY = 5 + randomizer.nextInt(100);
                Rectangle shape = new Rectangle();
                shape.setBounds(randomX, randomY, 30, 20);
                shapes.add(shape);
                undoPanel.repaint();

            }
        });

        JButton addEllipseButton = new JButton("Ellipse");

        addEllipseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                int randomX = 5 + randomizer.nextInt(100);
                int randomY = 5 + randomizer.nextInt(100);
                Ellipse2D shape = new Ellipse2D.Double(randomX, randomY, 80, 30);
                shapes.add(shape);
                undoPanel.repaint();

            }
        });

        JButton undoButton = new JButton("Undo");

        undoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                if (!shapes.isEmpty()) {

                    shapes.remove(shapes.size() - 1);
                    undoPanel.repaint();

                }

            }
        });

        bar.add(addRectangleButton);
        bar.add(addEllipseButton);
        bar.add(Box.createHorizontalGlue());
        bar.add(undoButton);

        frame.add(bar, BorderLayout.NORTH);
        frame.add(undoPanel, BorderLayout.CENTER);

        frame.setSize(400, 200);

        frame.setVisible(true);
    }

    public static void main(final String[] args) {

        new DrawingUndo();
    }

    private class UndoPanel extends JPanel {

        @Override
        public void paintComponent(final Graphics g) {

            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            for (Shape shape : shapes) {

                g2d.draw(shape);// or g2d.fill(shape) to have its interior filled
            }
        }

    }

}