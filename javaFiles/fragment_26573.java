long eventMask = AWTEvent.KEY_EVENT_MASK;

Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
    public void eventDispatched(AWTEvent e) {
        String paramString = e.paramString();
        // System.out.println(paramString);
        if (paramString.contains("KEY_RELEASED,keyCode=9,keyText=Tab,keyChar=Tab,modifiers=Ctrl,extModifiers=Ctrl")) {
            System.out.println("Ctrl+Tab keys are released");
        }
    }
}, eventMask);