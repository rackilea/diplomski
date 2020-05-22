public class TestMenu extends JComponent {

    protected static final int MAX_HEIGHT = 40;
    protected static final int LEFT_MARGIN = 5;
    protected static final int RIGHT_MARGIN = 5;

    protected static final ImageIcon BACKGROUND = new ImageIcon(TestMenu.class.getResource("/Menu.png"));

    private String text;

    public TestMenu() {

        setOpaque(false);
        text  = "This is some text";
        setFont(UIManager.getFont("Label.font"));

    }

    @Override
    public Dimension getPreferredSize() {

        FontMetrics fm = getFontMetrics(getFont());
        int width = fm.stringWidth(text) + LEFT_MARGIN + RIGHT_MARGIN;

        Dimension size = new Dimension(width, MAX_HEIGHT);

        return size;

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        int width = getWidth() - 1;
        int height = getHeight() - 1;

        BufferedImage imgLeft = new BufferedImage(LEFT_MARGIN, MAX_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        BufferedImage imgRight = new BufferedImage(RIGHT_MARGIN, MAX_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        BufferedImage imgBody = new BufferedImage(width - LEFT_MARGIN - RIGHT_MARGIN, MAX_HEIGHT, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = imgLeft.createGraphics();
        g2d.drawImage(BACKGROUND.getImage(), 0, 0, this);
        g2d.dispose();

        g2d = imgRight.createGraphics();
        g2d.drawImage(BACKGROUND.getImage(), RIGHT_MARGIN - BACKGROUND.getIconWidth(), 0, this);
        g2d.dispose();

        g2d = imgBody.createGraphics();
        g2d.drawImage(BACKGROUND.getImage(), -LEFT_MARGIN, 0, this);
        g2d.dispose();

        g2d = (Graphics2D) g;

        g2d.drawImage(imgLeft, 0, 0, this);
        g2d.drawImage(imgBody, LEFT_MARGIN, 0, this);
        g2d.drawImage(imgRight, width - RIGHT_MARGIN, 0, this);

        FontMetrics fm = g2d.getFontMetrics();

        int x = (width - fm.stringWidth(text)) / 2;
        int y = ((height - fm.getHeight()) / 2) + fm.getAscent();

        g2d.setColor(Color.WHITE);
        g2d.drawString(text, x, y);


    }

}