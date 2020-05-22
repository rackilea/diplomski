addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent evt) {

        switch (evt.getKeyCode()) {

            case KeyEvent.VK_UP:
                playery -= 22;
                repaint();
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                playery += 22;
                            }
                        },
                        100
                );
                break;
        }
    }
});