import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StickFigurePainter {

    private JComponent ui = null;

    StickFigurePainter() {
        initUI();
    }

    public void initUI() {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        ArrayList<StickFigure> list = new ArrayList<StickFigure>();
        list.add(new StickFigure(Color.RED, 0));
        list.add(new StickFigure(Color.GREEN, 110));
        list.add(new StickFigure(Color.BLUE, 220));

        ui.add(new StickCanvas(list));
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                StickFigurePainter o = new StickFigurePainter();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

class StickCanvas extends JPanel {

    private ArrayList<StickFigure> stickFigures;

    StickCanvas(ArrayList<StickFigure> stickFigures) {
        this.stickFigures = stickFigures;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (StickFigure stickFigure : stickFigures) {
            stickFigure.draw(g2);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        Area area = new Area();
        for (StickFigure stickFigure : stickFigures) {
            area.add(stickFigure.getStickFigure());
        }
        return area.getBounds().getSize();
    }
}

class StickFigure {

    private Area stickFigure;
    private Color color;

    StickFigure(Color color, int x) {
        this.color = color;
        stickFigure = new Area(new Ellipse2D.Double(x, 0, 100, 100));
        stickFigure.add(new Area(new Rectangle(x+25, 100, 50, 110)));
    }

    public Area getStickFigure() {
        return stickFigure;
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fill(stickFigure);
    }
}