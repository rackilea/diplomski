public class Room extends JPanel {

    private static int leftWidth = 100;
    private static int leftHeight = 100;
    private static int leftX;
    private static int leftY;

    private static int rightWidth = 100;
    private static int rightHeight = 100;
    private static int rightX;
    private static int rightY;

    public Room() {

        setBackground(new Color(122, 197, 205));
    }

    void init() {

        leftX = getWidth() / 8;
        leftY = getHeight() / 2 - leftHeight / 2;
        rightX = getWidth() * 7 / 8;
        rightY = getHeight() / 2 - rightHeight / 2;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(leftX, leftY, leftWidth, leftHeight);
        g2d.fillRect(rightX, rightY, rightWidth, rightHeight);
    }
}