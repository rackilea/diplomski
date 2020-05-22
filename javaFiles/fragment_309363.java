class PianoKey
extends JComponent {

    PianoKey(/* args */) {

        BufferedImage key = ImageIO.read(
            cl.getResource(IMAGE_DIRECTORY + "/key/white.png")
        );

        final Dimension sz = new Dimension(key.getWidth(), key.getHeight());
        setPreferredSize(sz);
        setMinimumSize(sz);
        setMaximumSize(sz);

        setImage(key);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage key = getImage();

        g.drawImage(key, 0, 0, key.getWidth(), key.getHeight(), null);
    }
}

class PianoKeyBoard
extends JPanel
implements MouseListener {

    PianoKeyBoard(/* args */) {

        setLayout(new GridLayout(25, 0));

        for( int i = 1; i <= 25; i++ ) {
            PianoKey key = new PianoKey(/* args */);

            key.addMouseListener(this);

            add(key);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        System.out.println("pressed");
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("clicked");
    }
    @Override
    public void mouseReleased(MouseEvent me) {
        System.out.println("released");
    }
    @Override
    public void mouseEntered(MouseEvent me) {
        System.out.println("entered");
    }
    @Override
    public void mouseExited(MouseEvent me) {
        System.out.println("exited");
    }
}

class Piano
extends JFrame {

    Piano() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new PianoKeyBoard(/* args */));

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Piano().setVisible(true);
            }
        });
    }
}