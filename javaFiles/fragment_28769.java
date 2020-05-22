SwingUtilities.invokeLater(new Runnable() {

    public void run() {                        
        MouseEvent event = new MouseEvent(
                menuB, MouseEvent.MOUSE_ENTERED, 0, 0, 0, 0, 0, false);
        menuB.dispatchEvent(event);
        menuY.setArmed(true);
    }
});