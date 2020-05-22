public class CustomGUI extends JFrame {

private JLabel frame, border, grip, exit, minimize;
private Point initialClick;

public CustomGUI() {
    initComponents();
}

private void initComponents() {
    setTitle("CustomGUI");
    setMinimumSize(new Dimension(640, 480));
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setUndecorated(true);
    setBackground(new Color(0, 0, 0, 0));
    setLayout(null);
    pack();

    frame = new JLabel();
    frame.setBounds(0, 0, 640, 480);
    frame.setIcon(new ImageIcon(getClass().getResource("frame.png"));

    border = new JLabel();
    border.setBounds(0, 0, 640, 480);
    border.setIcon(new ImageIcon(getClass().getResource("border.png"));

    grip = new JLabel();
    grip.setBounds(215, 0, 376, 25);
    grip.setIcon(new ImageIcon(getClass().getResource("grip.png"));
    grip.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent evt) {
            initialClick = evt.getPoint();
        }
    });
    grip.addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent evt) {
            int thisX = getLocation().x;
            int thisY = getLocation().y;
            int xMoved = (thisX + evt.getX()) - (thisX + initialClick.x);
            int yMoved = (thisY + evt.getY()) - (thisY + initialClick.y);
            int posX = thisX + xMoved;
            int posY = thisY + yMoved;
            setLocation(posX, posY);
        }
    });

    exit = new JLabel();
    exit.setBounds(620, 4, 32, 16);
    exit.setIcon(new ImageIcon(getClass().getResource("exit.png"));
    exit.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent evt) {
            dispatchEvent(new WindowEvent(new UI(), WindowEvent.WINDOW_CLOSING));
        }
        @Override
        public void mouseEntered(MouseEvent evt) {
            exit.setIcon(new ImageIcon(getClass().getResource("exitGlow.png"));
        }
        @Override
        public void mouseExited(MouseEvent evt) {
            exit.setIcon(new ImageIcon(getClass().getResource("exit.png"));
        }
    });

    minimize = new JLabel();
    minimize.setBounds(600, 4, 16, 16);
    minmize.setIcon(new ImageIcon(getClass().getResource("minimize.png"));
    minimize.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent evt) {
            setState(Frame.ICONIFIED);
        }
        @Override
        public void mouseEntered(MouseEvent evt) {
            minimize.setIcon(new ImageIcon(getClass().getResource("minimizeGlow.png"));
        }
        @Override
        public void mouseExited(MouseEvent evt) {
            minimize.setIcon(new ImageIcon(getClass().getResource("minimize.png"));
        }
    });

    add(minimize);
    add(exit);
    add(grip);
    add(border);
    add(frame);
}

public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
        new CustomGUI().setVisible(true);
    });
}
}