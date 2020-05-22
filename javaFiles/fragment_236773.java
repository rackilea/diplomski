// the event mask; adjust as desired
long eventMask = 
    AWTEvent.KEY_EVENT_MASK |
    AWTEvent.MOUSE_EVENT_MASK |
    AWTEvent.MOUSE_MOTION_EVENT_MASK |
    AWTEvent.INPUT_METHOD_EVENT_MASK;

// install a listener for receiving global events
Toolkit.getDefaultToolkit().addAWTEventListener(yourListenerInstance, eventMask);