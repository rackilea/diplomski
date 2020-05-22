public class Rock extends JLabel {

    Timer timer;
    private volatile boolean hasBeenUsed = false;

    public Rock() {
        super();
        setIcon(new ImageIcon(Rock.class.getResource("/Rock.png")));
        setBounds(415, 840, getPreferredSize().width, getPreferredSize().height);
        setVisible(false);
    }

    public void start(final int rise, final int run) {
        hasBeenUsed = true;
        setVisible(true);
        timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setBounds(getBounds().x + run / 20, getBounds().y
                                + -rise / 20, getBounds().width,
                                getBounds().height);

                if (getBounds().x < 0 || getBounds().y < 0
                                || getBounds().y > 1000) {
                    timer.stop();
                    hasBeenUsed = false;
                    setBounds(415, 840, getPreferredSize().width, getPreferredSize().height);
                }
            }
        });
        timer.start();
    }
}