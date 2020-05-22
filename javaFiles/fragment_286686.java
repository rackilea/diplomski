import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Puzzle {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Puzzle::new);
    }

    private final static int shape_x[] = { -100, 100, 100, 0, 0, -100 };
    private final static int shape_y[] = { -100, -100, 0, 0, 100, 100 };

    public Puzzle() {
        JFrame frame = new JFrame("Puzzle");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        View view = new View();
        frame.setContentPane(view);

        Shape l_shape = new Polygon(shape_x, shape_y, shape_x.length);
        view.pieces.add(new Piece(Color.YELLOW, l_shape,   0, 100, 100));
        view.pieces.add(new Piece(Color.GREEN,  l_shape, 180, 300, 300));
        view.pieces.add(new Piece(Color.RED,    l_shape,  65, 450, 145));

        frame.setVisible(true);
    }

}

@SuppressWarnings("serial")
class View extends JPanel {

    final List<Piece> pieces = new ArrayList<>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gc = (Graphics2D) g;
        for (Piece piece : pieces)
            piece.draw(gc);
    }
}

class Piece {
    final Color color;
    final Shape shape;
    final int angle;

    int x, y;   // Move pieces by by changing these

    Piece(Color color, Shape shape, int angle, int x, int y) {
        this.color = color;
        this.shape = shape;
        this.angle = angle;
        this.x = x;
        this.y = y;
    }

    void draw(Graphics2D gc) {
        AffineTransform tf = gc.getTransform();
        gc.translate(x, y);
        gc.rotate(Math.toRadians(angle));
        gc.setColor(color);
        gc.fill(shape);
        gc.setTransform(tf);
    }
}