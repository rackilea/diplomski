public class BallPane extends JPanel {

    protected static final int DISTANCE = 10;

    private Ball ball;

    private Timer resizeTimer;
    private ComponentListener componentListener;

    public BallPane() {

        setBall(new Ball());

        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "goDown");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "goUp");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "goLeft");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "goRight");

        am.put("goDown", new DownAction(this));
        am.put("goUp", new UpAction(this));
        am.put("goLeft", new LeftAction(this));
        am.put("goRight", new RightAction(this));

        setFocusable(true);
        requestFocusInWindow();

    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Ball getBall() {
        return ball;
    }

    @Override
    public void addNotify() {

        super.addNotify();

        componentListener = new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeTimer.restart();
            }
        };

        resizeTimer = new Timer(250, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                removeComponentListener(componentListener);
                Point p = new Point(getWidth() / 2, getHeight() / 2);
                getBall().setLocation(p);
                resizeTimer.stop();
                resizeTimer = null;
                repaint();
            }
        });
        resizeTimer.setRepeats(false);
        resizeTimer.setCoalesce(true);

        addComponentListener(componentListener);

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Ball ball = getBall();
        if (ball != null) {

            Graphics2D g2d = (Graphics2D) g;
            ball.paint(g2d);

        }

    }

    public static abstract class AbstractBallAction extends AbstractAction {

        private BallPane pane;

        public AbstractBallAction(BallPane pane) {
            this.pane = pane;
        }

        public BallPane getBallPane() {
            return pane;
        }

        public int getXDistance() {
            return 0;
        }

        public int getYDistance() {
            return 0;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            BallPane pane = getBallPane();
            Ball ball = pane.getBall();

            Point location = ball.getLocation();
            location.y += getYDistance();
            location.x += getXDistance();
            if (location.y < (ball.getWidth() / 2)) {
                location.y = (ball.getWidth() / 2);
            } else if (location.y > pane.getHeight() - 1 - ball.getHeight()) {
                location.y = pane.getHeight() - ball.getHeight();
            }
            if (location.x < (ball.getHeight() / 2)) {
                location.x = (ball.getHeight() / 2);
            } else if (location.x > pane.getWidth() - 1 - ball.getWidth()) {
                location.x = pane.getWidth() - ball.getWidth();
            }
            ball.setLocation(location);
            pane.repaint();
        }

    }

    public static class UpAction extends AbstractBallAction {

        public UpAction(BallPane pane) {
            super(pane);
            putValue(NAME, "Up");
        }

        @Override
        public int getYDistance() {
            return -DISTANCE;
        }

    }

    public static class DownAction extends AbstractBallAction {

        public DownAction(BallPane pane) {
            super(pane);
            putValue(NAME, "Down");
        }

        @Override
        public int getYDistance() {
            return DISTANCE;
        }

    }

    public static class LeftAction extends AbstractBallAction {

        public LeftAction(BallPane pane) {
            super(pane);
            putValue(NAME, "Left");
        }

        @Override
        public int getXDistance() {
            return -DISTANCE;
        }

    }

    public static class RightAction extends AbstractBallAction {

        public RightAction(BallPane pane) {
            super(pane);
            putValue(NAME, "Right");
        }

        @Override
        public int getXDistance() {
            return DISTANCE;
        }

    }

}