private Timer timer;
...

// 1 second delay
timer = new javax.swing.Timer(1000, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // next call
    }
});
timer.setRepeats(true);
timer.start();

public static void main(String args[]) {
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            Main m = new Main();
        }
    });
}

class MyRoll extends JPanel {
    // override paintComponent in case of custom painting
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ...
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(..., ...);
    }
}