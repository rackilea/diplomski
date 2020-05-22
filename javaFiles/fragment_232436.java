import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RectangleFrame1 extends JFrame implements ActionListener {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                RectangleFrame1 frame = new RectangleFrame1();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    JPanel buttonPanel;
    JButton saveImage;
    JButton clearImage;
    JCheckBox intersections;
    JCheckBox union;
    RectangleLabel drawingArea;
    boolean intersect = false;
    boolean uni = false;

    public RectangleFrame1() {
        super();
        setTitle("Rectangles");
        setSize(600, 600);
//        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(buttonPanel, BorderLayout.SOUTH);

        intersections = new JCheckBox("Draw Intersections");
        buttonPanel.add(intersections);
        intersections.addActionListener(this);
        intersections.setActionCommand("Intersections");

        union = new JCheckBox("Draw Union");
        buttonPanel.add(union);
        union.addActionListener(this);
        union.setActionCommand("Union");

        saveImage = new JButton("Save Image");
        saveImage.setMargin(new Insets(0, 0, 0, 0));
        buttonPanel.add(saveImage);
        saveImage.addActionListener(this);
        saveImage.setActionCommand("Save Image");

        clearImage = new JButton("Clear Image");
        clearImage.setMargin(new Insets(0, 0, 0, 0));
        buttonPanel.add(clearImage);
        clearImage.addActionListener(this);
        clearImage.setActionCommand("Clear Image");

        drawingArea = new RectangleLabel();
        drawingArea.setBorder(BorderFactory.createLineBorder(Color.blue));
        this.add(drawingArea, BorderLayout.CENTER);
        drawingArea.addMouseListener((MouseListener) drawingArea);
        drawingArea.addMouseMotionListener((MouseMotionListener) drawingArea);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        switch (arg0.getActionCommand()) {
            case "Intersections":
                intersect = intersections.isSelected();
                break;
            case "Union":
                uni = union.isSelected();
                break;
            case "Clear Image":
                drawingArea.clearImage();
                break;
            case "Save Image":
                drawingArea.saveImage();
                break;
        }
        repaint();
    }

    class RectangleLabel extends JLabel implements MouseListener, MouseMotionListener {

        Rectangle rectangle = null;
        int x, y, x2, y2;
        ArrayList<Rectangle> a = new ArrayList();

        public RectangleLabel() {
            super();
        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            x = arg0.getX();
            y = arg0.getY();

            rectangle = new Rectangle(x, y, 0, 0);
            a.add(rectangle);
        }

        @Override
        public void mouseDragged(MouseEvent arg0) {
            // TODO Auto-generated method stub
            x2 = arg0.getX();
            y2 = arg0.getY();

            if (rectangle.getX() > x2) {
                rectangle.setWidth(x - x2);
            }
            if (x2 > rectangle.getX()) {
                rectangle.setWidth(x2 - x);
            }
            if (y > y2) {
                rectangle.setHeight(y - y2);
            }
            if (y2 > y) {
                rectangle.setHeight(y2 - y);
            }

            repaint();

        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
            rectangle = null;
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseClicked(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Rectangle rect : a) {
                float thickness = 2;
                ((Graphics2D) g).setStroke(new BasicStroke(thickness));
                g.setColor(Color.BLUE);
                g.drawRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
                g.setColor(Color.gray);
                g.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
            }

            if (intersect) {
                for (int h = 0; h < a.size() - 1; h++) {
                    for (int j = 1; j < a.size(); j++) {
                        if (!a.get(h).equals(a.get(j)) && a.get(h).overlaps(a.get(j))) {
                            Rectangle rect = a.get(h).intersect(a.get(j));
                            g.setColor(Color.RED);
                            g.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
                        }
                    }
                }
            }

            if (uni) {
                for (int h = 0; h < a.size() - 1; h++) {
                    for (int j = 1; j < a.size(); j++) {
                        if (!a.get(h).equals(a.get(j)) && a.get(h).overlaps(a.get(j))) {
                            Rectangle rect = a.get(h).union(a.get(j));
                            g.setColor(Color.WHITE);
                            g.drawRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());

                        }
                    }
                }
            }
        }

        public void saveImage() {
            BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D aaaaa = image.createGraphics();
            aaaaa.setBackground(Color.WHITE);
            aaaaa.clearRect(0, 0, this.getWidth(), this.getHeight());
            this.paintAll(aaaaa);
            try {
                File output = new File("rectangle.png");
                ImageIO.write(image, "Rectangles", output);
            } catch (IOException ie) {

            }
        }

        public void clearImage() {
            a.clear();
            repaint();
        }

    }

    public class Rectangle {

        private int x, y, width, height;

        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public Rectangle(Rectangle a) {
            this.x = a.x;
            this.y = a.y;
            this.width = a.width;
            this.height = a.height;
        }

        public String toString() {
            return "Start: (" + x + "," + y + "), Width: " + width + ", Height: " + height + "\n";
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int area() {
            return width * height;
        }

        public boolean overlaps(Rectangle a) {
            if ((x > a.x + a.width) || (a.x > x + width) || (y > a.y + a.height) || (a.y > y + height)) {
                return false;
            }
            return true;
        }

        public Rectangle intersect(Rectangle a) {
            if (!overlaps(a)) {
                return null;
            }

            int left, right, top, bottom;

            if (x < a.x) {
                left = a.x;
            } else {
                left = x;
            }

            if (y < a.y) {
                bottom = a.y;
            } else {
                bottom = y;
            }

            if ((x + width) < (a.x + a.width)) {
                right = x + width;
            } else {
                right = a.x + a.width;
            }

            if ((y + height) < (a.y + a.height)) {
                top = y + height;
            } else {
                top = a.y + a.height;
            }

            return new Rectangle(left, bottom, right - left, top - bottom);
        }

        public Rectangle union(Rectangle a) {
            int left, right, top, bottom;

            if (x < a.x) {
                left = x;
            } else {
                left = a.x;
            }

            if (y < a.y) {
                bottom = y;
            } else {
                bottom = a.y;
            }

            if ((x + width) < (a.x + a.width)) {
                right = a.x + a.width;
            } else {
                right = x + width;
            }

            if ((y + height) < (a.y + a.height)) {
                top = a.y + a.height;
            } else {
                top = y + height;
            }

            return new Rectangle(left, bottom, right - left, top - bottom);
        }
    }
}