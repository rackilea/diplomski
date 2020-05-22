//add mouseover event bit to existing sunk event bits
Event.sinkEvents(span, Event.getEventsSunk(span) | Event.ONMOUSEOVER);
final EventListener oldListener = Event.getEventListener(span);
Event.setEventListener(span, new EventListener() {

    @Override
    public void onBrowserEvent(Event event) {

        if(Event.ONMOUSEOVER == event.getTypeInt()) {
            //your mouseover action
        }

        if(oldListener != null) {
            oldListener.onBrowserEvent(event);
        }
    }
});