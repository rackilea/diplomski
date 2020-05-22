@SuppressWarnings("serial")
class Card1 extends CardPanel {
    public static final String NAME = "Card 1";
    private static final Color COLOR_1 = Color.PINK;
    private static final Color COLOR_2 = new Color(150, 150, 255);
    private static final float WDTH = 20f;
    private static final int LBL_GAP = 40;

    public Card1(CardUser cardUser) {
        super(cardUser);
        setName(NAME);
        JLabel label = new JLabel(NAME);
        label.setFont(label.getFont().deriveFont(Font.BOLD, 128));
        label.setBorder(BorderFactory.createEmptyBorder(LBL_GAP, LBL_GAP, LBL_GAP, LBL_GAP));

        add(label);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Paint paint = new GradientPaint(0f, 0f, COLOR_1, WDTH, WDTH, COLOR_2, true);
        g2.setPaint(paint);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}