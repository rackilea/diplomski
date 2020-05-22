public class BorderWrapper {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Border Wrapper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main panel
        MainPanel panel = new MainPanel();
        frame.getContentPane().add(panel);

        // Display frame
        Dimension minSize = new Dimension(650, 375);
        frame.setPreferredSize(minSize);
        frame.setMinimumSize(minSize);
        frame.pack();
        frame.setVisible(true);
    }
}

class MainPanel extends JPanel {
    private static final Font INPUT_FONT = new Font("Monospaced", Font.PLAIN, 12);

    private JTextArea inputArea, outputArea;
    private JTextField titleField, topBorderField, sideBorderField;

    public MainPanel() {
        setLayout(new BorderLayout());

        // Set up config panel
        JPanel configPanel = new JPanel();
        configPanel.setLayout(new BoxLayout(configPanel, BoxLayout.X_AXIS));
        configPanel.setMaximumSize(new Dimension(400, 200));

        titleField = new JTextField(25);
        titleField.setFont(INPUT_FONT);
        topBorderField = new JTextField(1);
        topBorderField.setFont(INPUT_FONT);
        sideBorderField = new JTextField(4);
        sideBorderField.setFont(INPUT_FONT);

        configPanel.add(new JLabel("Title:"));
        configPanel.add(titleField);
        configPanel.add(new JLabel("Top border:"));
        configPanel.add(topBorderField);
        configPanel.add(new JLabel("Side border:"));
        configPanel.add(sideBorderField);

        add(configPanel, BorderLayout.NORTH);

        // Set up Input panel
        JPanel lowerPanel = new JPanel(new GridLayout(1, 1));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputArea = new JTextArea("Type or paste your stuff here . . .");
        inputArea.setFont(INPUT_FONT);
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        inputArea.setColumns(75);
        JScrollPane inputPane = new JScrollPane(inputArea);

        JLabel inputLabel = new JLabel("Text Box");
        inputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.add(inputLabel);
        inputPanel.add(inputPane);

        lowerPanel.add(inputPanel);

        // Set up Output panel
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS));
        outputArea = new JTextArea();
        outputArea.setFont(INPUT_FONT);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setColumns(75);
        JScrollPane outputPane = new JScrollPane(outputArea);

        JLabel outputLabel = new JLabel("Wrapped Output");
        outputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        outputPanel.add(outputLabel);
        outputPanel.add(outputPane);

        lowerPanel.add(outputPanel);
        add(lowerPanel, BorderLayout.CENTER);
    }
}