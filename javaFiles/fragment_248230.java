public class BounceThread extends JComponent implements ActionListener {
    JFrame frame;
    int myX = 500 / 2;
    int myY = 500 / 2;;

    int X;
    int Y;

    Canvas canvas;
    BufferStrategy bufferStrategy;
    boolean running = true;
    Random rand = new Random();

    int n = rand.nextInt(450) + 1;
    int n2 = rand.nextInt(450) + 1;

    public BounceThread() {
        frame = new JFrame("Basic Game");
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setLayout(null);
        canvas = new Canvas();
        canvas.setBounds(0, 0, 500, 500);
        // canvas.setIgnoreRepaint(true);
        panel.add(canvas);
        canvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                moveIt(evt);
                repaint();
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
    }

    public static void main(String[] args) {
        BounceThread ex = new BounceThread();
        int delay = 5000; // milliseconds
        new Timer(delay, ex).start();
    }

    @Override
    public void repaint() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Graphics2D e = (Graphics2D) bufferStrategy.getDrawGraphics();
        e.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.clearRect(0, 0, 500, 500);
        e.clearRect(0, 0, 500, 500);
        Paint(g, e);
        bufferStrategy.show();
        super.repaint();
    }

    protected void Paint(Graphics2D g, Graphics2D e) {
        g.fillOval(myX, myY, 30, 30);
        g.setColor(Color.red);
        e.fillOval(n, n2, 30, 30);
        e.setBackground(Color.white);
    }

    public void moveIt(KeyEvent evt) {
        switch (evt.getKeyCode()) {
        case KeyEvent.VK_DOWN:
            if (myY < 450) {
                myY += 10;
            }
            break;
        case KeyEvent.VK_UP:
            if (myY > 30) {
                myY -= 10;
            }
            break;
        case KeyEvent.VK_LEFT:
            if (myX > 30) {
                myX -= 10;
            }
            break;
        case KeyEvent.VK_RIGHT:
            if (myX < 450) {
                myX += 10;
            }
            break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        n = rand.nextInt(450) + 1;
        n2 = rand.nextInt(450) + 1;
        repaint();
    }
}