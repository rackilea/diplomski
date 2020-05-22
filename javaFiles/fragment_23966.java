AWTEventListener awtWindowListener = new AWTEventListener() {
    @Override
    public void eventDispatched(AWTEvent event) {
        if (event instanceof WindowEvent) {
            if (WindowEvent.WINDOW_CLOSED == event.getID()
                    || WindowEvent.WINDOW_CLOSING == event.getID()) {
                Window child = ((WindowEvent) event).getWindow();
                Window parent = SwingUtilities.getWindowAncestor(child);
                if (parent == null) return;
                InputContext childIC = child.getInputContext();
                parent.getInputContext().selectInputMethod(childIC.getLocale());
            }
        }

    }
};

Toolkit.getDefaultToolkit().addAWTEventListener(awtWindowListener, AWTEvent.WINDOW_EVENT_MASK);