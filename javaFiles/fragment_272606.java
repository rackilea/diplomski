long timeout = System.currentTimeMillis() + 500;
while (System.currentTimeMillis() < timeout) {
    eventPtr = OS.gdk_event_get ();
    if (eventPtr != 0) {
        break;
    } else {
        try {Thread.sleep(50);} catch (Exception ex) {}
    }
}