import com.google.gwt.user.client.Event;

FramedPanel randomFramedPanel = ...;
XElement headerElement = randomFramedPanel.getHeader().getElement();
Event.sinkEvents(headerElement, Event.ONCLICK);
Event.setEventListener(headerElement, new EventListener() {
    @Override
    public void onBrowserEvent(com.google.gwt.user.client.Event event) {
        if (Event.ONCLICK == event.getTypeInt()) {
            // Do something...
        }
    }
});