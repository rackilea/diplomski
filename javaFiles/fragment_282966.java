static int a = 0;

public static void main(String[] args) {
    JFrame f = new JFrame();
    JPanel p = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setBackground(new Color(255, 255, 255, 0));
            g2d.clearRect(0, 0, f.getWidth(), f.getHeight());
            g2d.drawRect(a, a++, 2, 2);
        }
    };
    f.add(p);
    f.setUndecorated(true);
    f.setBackground(new Color(255, 255, 255, 0));
    f.setSize(512, 512);
    f.setVisible(true);
    f.createBufferStrategy(2);

    BufferStrategy bs = f.getBufferStrategy();
    while (true) {
        try {
            Thread.sleep(33);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (System.getProperty("os.name").contains("indows ")) {
            p.repaint();
        } else {
            Graphics g = null;
            do {
                try {
                    g = bs.getDrawGraphics();
                    p.update(g);
                } finally {
                    g.dispose();
                }
                bs.show();
            } while (bs.contentsLost());
            Toolkit.getDefaultToolkit().sync();
        }
    }
}