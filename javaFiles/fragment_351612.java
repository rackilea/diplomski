void keylisteners() {
        MainFrame.addKeyListener(new java.awt.event.KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                    if (walking == true && direction != 0) {
                        MT.cancel();
                    }

public void keyTyped(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                    if (direction == 0) {
                        thing.setIcon(new ImageIcon("images\\walk0b.png"));
                        MT.cancel();
                    }
                }