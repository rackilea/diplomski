@SuppressWarnings("serial")
class Card2 extends CardPanel {
    public static final String NAME = "Card 2";
    private static final Color COLOR_1 = Color.BLACK;
    private static final Color COLOR_2 = Color.BLUE;
    private static final Color LABEL_FG = Color.LIGHT_GRAY;
    private static final String[] DATA = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private JLabel label = new JLabel("Card 2", SwingConstants.CENTER);
    private JComboBox<String> comboBox = new JComboBox<>(DATA);

    public Card2(CardUser cardUser) {
        super(cardUser);
        setName(NAME);
        label.setForeground(LABEL_FG);

        JPanel centralPanel = new JPanel(new GridBagLayout());
        centralPanel.setOpaque(false);
        centralPanel.add(comboBox);

        add(label, BorderLayout.PAGE_START);
        add(centralPanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Paint paint = new GradientPaint(0f, 0f, COLOR_1, getWidth(), getHeight(), COLOR_2, false);
        g2.setPaint(paint);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }    
}