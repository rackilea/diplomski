class gameplay {
    static String current_key = "stop";

    public gameplay() {
        begin();
    }

    void begin() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tutorial3.class.getName()).log(Level.SEVERE, null, ex);
            }
            Tutorial3.panel.user.move(current_key);
            Tutorial3.panel.repaint();
            System.out.println(current_key);
//          current_key = "stop"; // only "stop" when the key is released
        }
    }

    static void key_event() {}
}

class MyKeyListener extends KeyAdapter {
    // set direction to "stop" when a key is released
    @Override
    public void keyReleased(KeyEvent e) {
        gameplay.current_key = "stop";
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                gameplay.current_key = "up";
                break;
            case KeyEvent.VK_DOWN:
                gameplay.current_key = "down";
                break;
            case KeyEvent.VK_LEFT:
                gameplay.current_key = "left";
                break;
            case KeyEvent.VK_RIGHT:
                gameplay.current_key = "right";
                break;
            default:
                gameplay.current_key = "stop";
        }
    }
}