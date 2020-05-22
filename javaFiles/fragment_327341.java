public static void main(String[] args) {
    EventQueue.invokeLater(Example::new);
}

// this is the painting-related data that is being manipulated by the timer
private int currentColorIndex;

public Example() {
    JFrame frame = new JFrame("Custom Painting");
    frame.setSize(640, 480);
    frame.setLocationRelativeTo(null);

    Color[] allColors = {Color.RED, Color.BLUE, Color.GREEN,
            Color.YELLOW, Color.ORANGE, Color.MAGENTA};

    JPanel myCustomPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            // here the painting related data is being used by the custom JPanel implementation
            g.setColor(allColors[currentColorIndex]);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };
    frame.setContentPane(myCustomPanel);

    Timer timer = new Timer(100, e -> {
        // the timer does not use any graphics objects, etc, but rather manipulates our painting-related data
        currentColorIndex = (currentColorIndex + 1) % allColors.length;
        // whenever the painting-related data has changed we need to call repaint() on our custom JPanel implementation
        myCustomPanel.repaint();
    });
    timer.setRepeats(true);
    timer.start();

    frame.setVisible(true);
}