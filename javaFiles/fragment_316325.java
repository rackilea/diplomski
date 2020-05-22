import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class World extends JPanel implements Runnable {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                new World(new BasicRobot(0, 0, BasicRobot.FACING.SOUTH, 100));
            }
        });
    }

    private final int ROWS = 30, COLS = 30, BLOCK_SCALE = 24, WALL_WIDTH = BLOCK_SCALE / 3;
    private final Dimension DIMS = new Dimension(COLS * BLOCK_SCALE, ROWS * BLOCK_SCALE);
    private final JFrame frame = new JFrame("World");
    private final Polygon NORTH_TRIANGLE = new Polygon(new int[]{5, BLOCK_SCALE / 2, BLOCK_SCALE - 5}, new int[]{BLOCK_SCALE - 3, 2, BLOCK_SCALE - 3}, 3);
    private final Polygon WEST_TRIANGLE = new Polygon(new int[]{1, BLOCK_SCALE - 4, BLOCK_SCALE - 4}, new int[]{BLOCK_SCALE / 2, 5, BLOCK_SCALE - 5}, 3);
    private final Polygon SOUTH_TRIANGLE = new Polygon(new int[]{5, BLOCK_SCALE / 2, BLOCK_SCALE - 5}, new int[]{3, BLOCK_SCALE - 2, 3}, 3);
    private final Polygon EAST_TRIANGLE = new Polygon(new int[]{4, 4, BLOCK_SCALE - 1}, new int[]{BLOCK_SCALE - 5, 5, BLOCK_SCALE / 2}, 3);
    private final int obsticleMap[][] = new int[COLS][ROWS];
//    private final Wall obsticles[] = {
//        new Wall(1, 1, 5, WALL_WIDTH, Wall.ALIGNMENT_HORIZONTAL),
//        new Wall(1, 1, 5, WALL_WIDTH, Wall.ALIGNMENT_VERTICAL),
//        new Wall(1, 5, 3, WALL_WIDTH, Wall.ALIGNMENT_HORIZONTAL)
//    }; //The Wall class is just data nothing of interest there

    BasicRobot robot;

    public World(BasicRobot robot) {
        super(null);

        this.robot = robot;
        initThis();
        initFrame();
        initObsticleMap();
    }

    private void initThis() {
        setBackground(Color.white);
        setSize(DIMS);
        setLocation(1, 1);
        setBorder(new LineBorder(Color.black));
//        Thread t = new Thread(this);
//        t.start();
        initKeyBindings();
    }

    private void initFrame() {
        frame.setContentPane(new Container() {
            private static final long serialVersionUID = 1L;

            public void paint(Graphics g) {
                super.paint(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
                g2d.drawRect(0, 0, DIMS.width + 1, DIMS.height + 1);
                g2d.drawLine(0, DIMS.height + 2, DIMS.width + 1, DIMS.height + 2);
                g2d.setFont(new Font("Serif", Font.BOLD, 18));
                g2d.drawString(String.format("Loc X = %d", robot.xLoc), 20, DIMS.height + 22);
                g2d.drawString(String.format("Loc Y = %d", robot.yLoc), 20, DIMS.height + 42);
                g2d.drawString(String.format("Beepers in bag = %d", robot.beepers), 150, DIMS.height + 22);
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setPreferredSize(new Dimension(DIMS.width + 2, DIMS.height + 50));
        frame.setResizable(false);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initObsticleMap() {
//        for (int i = 0; i < obsticles.length; i++) {
//            switch (obsticles[i].alignment) {
//                case Wall.ALIGNMENT_HORIZONTAL:
//                    for (int j = 0; j < obsticles[i].span; j++) {
//                        obsticleMap[obsticles[i].xLoc + j][obsticles[i].yLoc] = 1;
//                    }
//                    break;
//                case Wall.ALIGNMENT_VERTICAL:
//                    for (int j = 0; j < obsticles[i].span; j++) {
//                        obsticleMap[obsticles[i].xLoc][obsticles[i].yLoc + j] = 1;
//                    }
//                    break;
//            }
//        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        drawGrid(g2d);
        drawObsticles(g2d);
        drawRobot(g2d);
    }

    private void drawGrid(Graphics2D g) {
        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                g.drawRect(i * BLOCK_SCALE, j * BLOCK_SCALE, BLOCK_SCALE - 1, BLOCK_SCALE - 1);
            }
        }
    }

    private void drawObsticles(Graphics2D g2d) {
//        for (int i = 0; i < obsticles.length; i++) {
//            switch (obsticles[i].alignment) {
//                case Wall.ALIGNMENT_HORIZONTAL:
//                    g2d.fillRoundRect(obsticles[i].xLoc * BLOCK_SCALE - BLOCK_SCALE / 2, (ROWS - obsticles[i].yLoc) * BLOCK_SCALE - obsticles[i].width / 2, BLOCK_SCALE * obsticles[i].span, obsticles[i].width, 2, 2);
//                    break;
//                case Wall.ALIGNMENT_VERTICAL:
//                    g2d.fillRoundRect(obsticles[i].xLoc * BLOCK_SCALE - obsticles[i].width / 2, (ROWS - obsticles[i].yLoc - obsticles[i].span + 1) * BLOCK_SCALE - BLOCK_SCALE / 2, obsticles[i].width, BLOCK_SCALE * obsticles[i].span, 2, 2);
//                    break;
//            }
//        }
    }

    private void drawRobot(Graphics2D g) {
        Polygon translated;
        switch (robot.facing) {
            case NORTH:
                translated = new Polygon(NORTH_TRIANGLE.xpoints, NORTH_TRIANGLE.ypoints, 3);
                break;
            case WEST:
                translated = new Polygon(WEST_TRIANGLE.xpoints, WEST_TRIANGLE.ypoints, 3);
                break;
            case SOUTH:
                translated = new Polygon(SOUTH_TRIANGLE.xpoints, SOUTH_TRIANGLE.ypoints, 3);
                break;
            case EAST:
                translated = new Polygon(EAST_TRIANGLE.xpoints, EAST_TRIANGLE.ypoints, 3);
                break;
            default:
                translated = new Polygon(EAST_TRIANGLE.xpoints, EAST_TRIANGLE.ypoints, 3);
        }

        translated.translate(robot.xLoc * BLOCK_SCALE - BLOCK_SCALE / 2, (ROWS - robot.yLoc) * BLOCK_SCALE - BLOCK_SCALE / 2);
        g.setColor(Color.yellow);
        g.fillPolygon(translated);
        g.setColor(Color.black);
        g.drawPolygon(translated);
    }

    public void run() {
//        for (;;) {
//            try {
//                frame.repaint();
//                Thread.sleep(40);
//            } catch (Exception e) {
//                e.toString();
//            }
//        }
    }

    public void initKeyBindings() {
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "move");
        getActionMap().put("move", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("move");
                robot.move();
                repaint();
            }
        });
    }

    public static class BasicRobot {

        public static enum FACING {

            NORTH, WEST, SOUTH, EAST
        }

        int xLoc, yLoc;
        FACING facing;
        int beepers;

        public BasicRobot(int xLoc, int yLoc, FACING facing, int beepers) {
            this.xLoc = xLoc;
            this.yLoc = yLoc;
            this.facing = facing;
            this.beepers = beepers;
        }

        public void move() {
//            try {
//                Thread.sleep(300);
//            } catch (Exception e) {
//                e.toString();
//            }
            switch (facing) {
                case NORTH:
                    yLoc++;
                    break;
                case WEST:
                    xLoc--;
                    break;
                case SOUTH:
                    yLoc--;
                    break;
                case EAST:
                    xLoc++;
                    break;
            }
        }

        public void turnLeft() {
//            try {
//                Thread.sleep(300);
//            } catch (Exception e) {
//                e.toString();
//            }
            switch (facing) {
                case NORTH:
                    facing = FACING.WEST;
                    break;
                case WEST:
                    facing = FACING.SOUTH;
                    break;
                case SOUTH:
                    facing = FACING.EAST;
                    break;
                case EAST:
                    facing = FACING.NORTH;
                    break;
            }
        }

    }
}