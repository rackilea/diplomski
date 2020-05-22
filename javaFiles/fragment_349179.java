EventQueue eventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
List<AWTEvent> events = new ArrayList<AWTEvent>();
eventQueue.postEvent(new PaintEvent(DetailPanel.this, PaintEvent.PAINT, new Rectangle(10, 10));
while (eventQueue.peekEvent() != null) {
    events.add(eventQueue.getNextEvent());
}
..... // modal window code
For (AWTEvent event : events) {
    eventQueue.postEvent(event);
}