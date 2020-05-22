import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelParaFirmar extends JPanel {
    private final MouseHandler mouseHandler = new MouseHandler();

    private final List<List<Point>> lines = new ArrayList<>();
    private List<Point> currentLine;

    public static void main(final String[] args) {

        JFrame fr = new JFrame();
        fr.setSize(400, 200);
        fr.getContentPane().add(new PanelParaFirmar());
        fr.setVisible(true);
    }

    public PanelParaFirmar() {
        this.setBackground(Color.WHITE);
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }

    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        for (List<Point> line : lines) {

            for (int i = 0; i < line.size() - 1; i++) {

                Point thisPoint = line.get(i);
                Point nextPoint = line.get(i + 1);

                g.drawLine(thisPoint.x, thisPoint.y, nextPoint.x, nextPoint.y);

            }
        }

    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mousePressed(final MouseEvent e) {

            currentLine = new ArrayList<Point>();
            currentLine.add(new Point(e.getX(), e.getY()));

            lines.add(currentLine);

            repaint();
        }

        @Override
        public void mouseDragged(final MouseEvent e) {

            Point p = new Point(e.getX(), e.getY());
            currentLine.add(p);
            repaint();
        }


    }

}