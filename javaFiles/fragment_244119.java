/**
     * Holds the state of the "useful" keys (true if down, false if not).
     */
    private Set<Integer> keys;

    /**
     * Determines if the "useful" keys are down or not. Sets the variables
     * to true if they're down and false if they're up.
     */
    public void update() {

        keys = new HashSet<>(8);
    }

    public boolean isKeyPressed(int key) {
        return keys.contains(key);
    }

    public boolean isWPressed() {
        return isKeyPressed(KeyEvent.VK_W);
    }

    public boolean isAPressed() {
        return isKeyPressed(KeyEvent.VK_A);
    }

    public boolean isSPressed() {
        return isKeyPressed(KeyEvent.VK_S);
    }

    public boolean isDPressed() {
        return isKeyPressed(KeyEvent.VK_D);
    }

    public boolean isUpPressed() {
        return isKeyPressed(KeyEvent.VK_UP);
    }

    public boolean isDownPressed() {
        return isKeyPressed(KeyEvent.VK_DOWN);
    }

    public boolean isLeftPressed() {
        return isKeyPressed(KeyEvent.VK_LEFT);
    }

    public boolean isRightPressed() {
        return isKeyPressed(KeyEvent.VK_RIGHT);
    }
    /**
     * Changes the state of the pressed key's corresponding boolean in the
     * array to true.
     */
    public void keyPressed(KeyEvent e) {
        System.out.println("Pressed = " + e.getKeyCode());
        keys.add(e.getKeyCode());
    }

    /**
     * Changes the state of the pressed key's corresponding boolean in the
     * array to false.
     */
    public void keyReleased(KeyEvent e) {
        System.out.println("Released = " + e.getKeyCode());
        keys.remove(e.getKeyCode());
    }

    public void keyTyped(KeyEvent e) {
    }
}