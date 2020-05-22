public class Example extends JFrame implements ComponentListener {
    private static final int ROWS = 20;
    private static final int COLUMNS = 20;
    private JLabel widthLabel;
    private JPanel greenPanel;

    public Example() {
        super("test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel redPanel = new JPanel();
        redPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

        widthLabel = new JLabel();
        redPanel.add(widthLabel);

        greenPanel = new JPanel(new GridLayout(ROWS, COLUMNS));
        greenPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
        greenPanel.addComponentListener(this);
        for (int i = 0; i < ROWS * COLUMNS; i++) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

            greenPanel.add(panel);
        }

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, redPanel, greenPanel);

        add(splitPane);
        setLocationByPlatform(true);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Example().setVisible(true);
        });
    }

    @Override
    public void componentResized(ComponentEvent e) {
        widthLabel.setText("Green panel's width: " + greenPanel.getWidth());
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

}