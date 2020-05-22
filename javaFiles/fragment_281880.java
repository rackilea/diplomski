public class TestApplet02 extends Applet implements KeyListener, Runnable {

    Button options = new Button("Options");
    Thread thread = new Thread(this);
    int y = 0;

    public void init() {
        thread.start();
    }

    @Override
    public void start() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setLayout(new BorderLayout());
                addKeyListener(TestApplet02.this);
            }
        });
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D g2d = (Graphics2D) graphics;
        y++;
        if (y > getHeight()) {
            y = 0;
        }
        g2d.drawLine(0, y, getWidth(), y);
    }

    public void run() {
        try {
            while (true) {
                thread.sleep(40);
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        repaint();
                    }
                });
            }
        } catch (InterruptedException exception) {
        }
    }

    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                // pause game
                add(options);
                invalidate();
                revalidate();
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
    }

    public void keyTyped(KeyEvent keyEvent) {
    }
}