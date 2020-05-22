public class TestPane extends JPanel {

    private List<Box> boxes;
    private Color[] colors = {Color.RED, Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.WHITE, Color.YELLOW};

    public TestPane() {
        boxes = new ArrayList<>(25);
        for (int index = 0; index < 100; index++) {
            Color color = colors[(int) (Math.random() * colors.length)];
            int width = 10 + (int) (Math.random() * 9);
            int height = 10 + (int) (Math.random() * 9);
            boxes.add(new DefaultBox(color, new Dimension(width, height)));
        }

        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Box box : boxes) {
                    box.update(getSize());
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Box box : boxes) {
            Graphics2D g2d = (Graphics2D) g.create();
            box.paint(g2d);
            g2d.dispose();
        }
    }

}