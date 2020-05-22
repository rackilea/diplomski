import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Assign72 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DrawingFrame f= new DrawingFrame();
                f.setTitle("Drawing Program");
                f.setSize(462,312);
                f.setLocationRelativeTo(null);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }

    public static class DrawingFrame
    extends JFrame
    implements ActionListener {
        private DrawingPanel drawPanel;
        private JPanel panel;
        private JPanel colorPanel;
        private JPanel sizePanel;
        private JRadioButton redRadioButton;
        private JRadioButton blueRadioButton;
        private JRadioButton greenRadioButton;
        private JRadioButton blackRadioButton;
        private JRadioButton smallRadioButton;
        private JRadioButton mediumRadioButton;
        private JRadioButton largeRadioButton;
        private JButton eraseButton;
        private ButtonGroup colorButtonGroup;
        private ButtonGroup sizeButtonGroup;

        static final int SMALL = 4; // constants are static
        static final int MEDIUM = 8;
        static final int LARGE = 10;

        public DrawingFrame() {
            colorPanel = new JPanel();
            sizePanel = new JPanel();

            redRadioButton = new JRadioButton();
            redRadioButton.setText("Red");
            colorPanel.add(redRadioButton);
            redRadioButton.addActionListener(this);

            blueRadioButton = new JRadioButton();
            blueRadioButton.setText("Blue");
            colorPanel.add(blueRadioButton);
            blueRadioButton.addActionListener(this);

            greenRadioButton = new JRadioButton();
            greenRadioButton.setText("Green");
            colorPanel.add(greenRadioButton);
            greenRadioButton.addActionListener(this);

            blackRadioButton = new JRadioButton();
            blackRadioButton.setText("Black");
            colorPanel.add(blackRadioButton);
            blackRadioButton.addActionListener(this);

            smallRadioButton = new JRadioButton();
            smallRadioButton.setText("Small");
            sizePanel.add(smallRadioButton);
            smallRadioButton.addActionListener(this);

            mediumRadioButton = new JRadioButton();
            mediumRadioButton.setText("Medium");
            sizePanel.add(mediumRadioButton);
            mediumRadioButton.addActionListener(this);

            largeRadioButton = new JRadioButton();
            largeRadioButton.setText("Large");
            sizePanel.add(largeRadioButton);
            largeRadioButton.addActionListener(this);
            colorButtonGroup = new ButtonGroup();
            sizeButtonGroup = new ButtonGroup();

            sizeButtonGroup.add(smallRadioButton);
            sizeButtonGroup.add(mediumRadioButton);
            sizeButtonGroup.add(largeRadioButton);

            colorButtonGroup.add(redRadioButton);

            colorButtonGroup.add(blueRadioButton);
            colorButtonGroup.add(greenRadioButton);
            colorButtonGroup.add(blackRadioButton);

            redRadioButton.setSelected(true);
            largeRadioButton.setSelected(true);
            JPanel configurePanel = new JPanel();
            configurePanel.add(new JButton("Configure"));

            // Will be right-aligned.

            // The full panel.
            panel = new JPanel();
            panel.setBackground(Color.YELLOW);

            drawPanel = new DrawingPanel(Color.RED, LARGE);
            drawPanel.setBackground( Color.WHITE );

            this.add(sizePanel, BorderLayout.PAGE_START);
            this.add(colorPanel, BorderLayout.PAGE_END);

            this.add(drawPanel,BorderLayout.CENTER);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (redRadioButton.isSelected())
                drawPanel.setCircleColor(Color.RED);
            if (greenRadioButton.isSelected())
                drawPanel.setCircleColor(Color.GREEN);
            if (blueRadioButton.isSelected())
                drawPanel.setCircleColor(Color.BLUE);
            if (blackRadioButton.isSelected())
                drawPanel.setCircleColor(Color.BLACK);
            if (smallRadioButton.isSelected())
                drawPanel.setCircleDiameter(SMALL);
            if (mediumRadioButton.isSelected())
                drawPanel.setCircleDiameter(MEDIUM);
            if (largeRadioButton.isSelected())
                drawPanel.setCircleDiameter(LARGE);
        }
    }

    public static class DrawingPanel
    extends JPanel
    implements MouseMotionListener {
        private int circleSize;
        private Color circleColor;
        private Circle newCircle;
        private Circle drawingCircle;

        private ArrayList<Circle> circleArrayList = new ArrayList<Circle>();

        DrawingPanel(Color colorValue, int size) {
            setCircleColor(colorValue);
            setCircleDiameter(size);
            addMouseMotionListener(this);
        }

        public void setCircleColor(Color choice) {
            circleColor = choice;
        }

        public Color getCircleColor() {
            return circleColor;
        }

        public void setCircleDiameter(int diameter) {
            circleSize = diameter;
        }

        public int getCircleSize() {
            return circleSize;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponents(g);

            // use regular for loop
            for(Circle c : circleArrayList) {
                c.draw(g);
            }
        }

        @Override
        public void mouseDragged(MouseEvent event) {
            newCircle = new Circle(getCircleSize(), event.getPoint(),
                    getCircleColor());
            circleArrayList.add(newCircle);
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent arg0) {}
    }

    public static class Circle {
        private int size;
        private Point point;
        private Color color;

        public Circle(int size, Point point, Color color) {
            setSize(size);
            setLocation(point);
            setColor(color);
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public Point getLocation() {
            return point;
        }

        public void setLocation(Point point) {
            this.point = point;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(point.x, point.y, size, size);
        }
    }
}