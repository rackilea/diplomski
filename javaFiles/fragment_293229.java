/**
     * Override the behaviour so that TAB key transfers the focus
     * to the next focusable component.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_TAB) {
            System.out.println(e.getModifiers());
            if(e.getModifiers() > 0) a.transferFocusBackward();
            else a.transferFocus(); 
            e.consume();
        }
    }