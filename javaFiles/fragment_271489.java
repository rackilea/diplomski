public static void main(String[] args) throws AWTException {

    final JFrame frame = new JFrame("Test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(new Dimension(400, 400));

    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

    final Robot r = new Robot();

    JLabel label = new JLabel("Hello World");
    label.setBackground(Color.ORANGE);
    label.setOpaque(true);

    label.addMouseMotionListener(new MouseMotionListener() {
        public void mouseMoved(MouseEvent e)    {}
        public void mouseDragged(MouseEvent e)    {
            JLabel label = (JLabel) e.getSource();
            Point point = label.getLocationOnScreen();
            point.x += (label.getWidth() / 2);
            point.y += (label.getHeight() / 2);
            r.mouseMove(point.x, point.y);

            Point movedPoint = e.getLocationOnScreen();

            int diffX = point.x - movedPoint.x;
            int diffY = point.y - movedPoint.y;
            System.out.println("Dragged: " + diffX + ", " + diffY);
        }
    });

    panel.add(label);
    frame.add(panel);
    frame.setVisible(true);
}