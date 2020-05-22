import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Random random = new Random();

        public TestPane() {
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            RenderingHints renderingHints1 = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
            RenderingHints renderingHints2 = new RenderingHints(RenderingHints.KEY_RENDERING,
                            RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHints(renderingHints1);
            g2d.setRenderingHints(renderingHints2);
            for (int i = 0; i < 10; i++) {
                Rectangle rectangle = new Rectangle(Color.CYAN, 
                                Color.BLACK, 
                                random.nextInt(10), 
                                random.nextInt(200), 
                                random.nextInt(200), 
                                random.nextInt(200), random.nextInt(200));
                rectangle.set_fill_transparency(random.nextInt(255));
                rectangle.set_rotate_angle(random.nextInt(180));
                Graphics2D iDontTrustYou = (Graphics2D) g2d.create();
                rectangle.render(iDontTrustYou);
                iDontTrustYou.dispose();
            }
            g2d.dispose();
        }

    }

    public abstract class Figure {

        public static final int TOPLEFT = 0;
        public static final int TOPCENTER = 1;
        public static final int TOPRIGHT = 2;
        public static final int CENTERLEFT = 3;
        public static final int CENTER = 4;
        public static final int CENTERRIGHT = 5;
        public static final int BOTTOMLEFT = 6;
        public static final int BOTTOMCENTER = 7;
        public static final int BOTTOMRIGHT = 8;

        private boolean fill_able;
        private int fill_option;
        private Color fill_color;
        private int fill_transparency;

        private Color line_color;
        private float line_thickness;
        private int line_transparency;

        private int width;
        private int height;
        private float rotate_angle;

        private boolean width_height_ratio_fixed;

        private Point location;
        private int base;

        public Figure(boolean fill_able,
                        int fill_option,
                        Color fill_color,
                        int fill_transparency,
                        Color line_color,
                        float line_thickness,
                        int line_transparency,
                        int width, int height,
                        float rotate_angle,
                        boolean width_height_ratio_fixed,
                        int x, int y,
                        int base) {
            this.fill_able = fill_able;
            this.fill_option = fill_option;
            this.fill_color = fill_color;
            this.fill_transparency = fill_transparency;
            this.line_color = line_color;
            this.line_thickness = line_thickness;
            this.line_transparency = line_transparency;
            this.width = width;
            this.height = height;
            this.rotate_angle = rotate_angle;
            this.width_height_ratio_fixed = width_height_ratio_fixed;
            this.location = new Point(x, y);
            this.base = base;
        }

        public boolean is_fill_able() {
            return fill_able;
        }

        public int get_fill_option() {
            return fill_option;
        }

        public Color get_fill_color() {
            return fill_color;
        }

        public int get_fill_transparency() {

            return fill_transparency;
        }

        public Color get_line_color() {
            return line_color;
        }

        public float get_line_thickness() {
            return line_thickness;
        }

        public int get_line_transparency() {
            return line_transparency;
        }

        public int get_width() {
            return width;
        }

        public int get_height() {
            return height;
        }

        public float get_rotate_angle() {
            return rotate_angle;
        }

        public boolean is_width_height_ratio_fixed() {
            return width_height_ratio_fixed;
        }

        public Point get_location() {
            return location;
        }

        public Point get_render_location() {
            int x, y;

            switch (base) {
                case TOPLEFT:
                    x = location.x;
                    y = location.y;
                    break;
                case TOPCENTER:
                    x = location.x - (int) Math.round(width / 2);
                    y = location.y;
                    break;
                case TOPRIGHT:
                    x = location.x - width;
                    y = location.y;
                    break;
                case CENTERLEFT:
                    x = location.x;
                    y = location.y - (int) Math.round(height / 2);
                    break;
                case CENTER:
                    x = location.x - (int) Math.round(width / 2);
                    y = location.y - (int) Math.round(height / 2);
                    break;
                case CENTERRIGHT:
                    x = location.x - width;
                    y = location.y - (int) Math.round(height / 2);
                    break;
                case BOTTOMLEFT:
                    x = location.x;
                    y = location.y - height;
                    break;
                case BOTTOMCENTER:
                    x = location.x - (int) Math.round(width / 2);
                    y = location.y - height;
                    break;
                case BOTTOMRIGHT:
                    x = location.x - width;
                    y = location.y - height;
                    break;
                default:
                    x = 0;
                    y = 0;
                    break;
            }

            return new Point(x, y);
        }

        public int get_base() {
            return base;
        }

        public void set_fill_option(int option) {
            this.fill_option = option;
        }

        public void set_fill_color(Color color) {
            this.fill_color = color;
        }

        public void set_fill_transparency(int transparency) {
            this.fill_transparency = transparency;
        }

        public void set_line_color(Color color) {
            this.line_color = color;
        }

        public void set_line_transparency(int transparency) {
            this.line_transparency = transparency;
        }

        public void set_width(int width) {
            if (this.width_height_ratio_fixed) {
                float ratio = this.height / this.width;
                this.width = width;
                this.height = (int) Math.round(width * ratio);
            } else {
                this.width = width;
            }
        }

        public void set_height(int height) {
            if (this.width_height_ratio_fixed) {
                float ratio = this.width / this.height;
                this.height = height;
                this.width = (int) Math.round(height * ratio);
            } else {
                this.height = height;
            }
        }

        public void set_rotate_angle(float angle) {
            if (angle > 360) {
                this.rotate_angle = angle % 360;
            } else {
                this.rotate_angle = angle;
            }
        }

        public void set_location(int x, int y) {
            this.location.setLocation(x, y);
        }

        public void set_location(Point location) {
            this.location = location;
        }

        public void set_base(int base) {
            this.base = base;
        }

        abstract public void render(Graphics2D g);
    }

    public class Rectangle extends Figure {

        public Rectangle(Color fill_color, Color line_color, float line_thickness, int width, int height, int x, int y) {
            super(true,
                            0,
                            fill_color,
                            255,
                            line_color,
                            line_thickness,
                            255,
                            width, height,
                            0,
                            false,
                            x, y,
                            TOPLEFT);
        }

        public void render(Graphics2D g) {
            Rectangle2D rectangle = new Rectangle2D.Float(get_width(), get_height(), get_render_location().x, get_render_location().y);

            g.rotate(Math.toRadians(get_rotate_angle()), rectangle.getCenterX(), rectangle.getCenterY());

            if (is_fill_able()) {
                Color color = new Color(
                                get_fill_color().getRed(),
                                get_fill_color().getGreen(),
                                get_fill_color().getBlue(),
                                get_fill_transparency());
                g.setColor(color);
                g.fill(rectangle);
            }

            Stroke old_stroke = g.getStroke();
            g.setStroke(new BasicStroke(get_line_thickness()));

            Color line_color = new Color(
                            get_line_color().getRed(),
                            get_line_color().getGreen(),
                            get_line_color().getBlue(),
                            get_line_transparency());
            g.setColor(line_color);
            g.draw(rectangle);

            g.setStroke(old_stroke);
            g.rotate(Math.toRadians(get_rotate_angle() * -1), rectangle.getCenterX(), rectangle.getCenterY());
        }
    }

}