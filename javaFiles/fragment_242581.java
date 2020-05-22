class EventQueueProxy extends EventQueue {

    protected void dispatchEvent(AWTEvent newEvent) {
        try {
            super.dispatchEvent(newEvent);
        } catch (Throwable t) {
            // do something more useful than: t.printStackTrace();
        }
    }
}