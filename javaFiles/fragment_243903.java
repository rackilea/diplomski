Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
    @Override
    public void eventDispatched(AWTEvent event) {
        System.out.println(event);
    }
}, AWTEvent.MOUSE_EVENT_MASK | AWTEvent.KEY_EVENT_MASK);