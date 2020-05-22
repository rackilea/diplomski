//add mouseover event bit to existing sunk event bits
Event.sinkEvents(span, Event.ONCLICK | Event.ONMOUSEOVER | Event.ONMOUSEOUT);
Event.setEventListener(span, new EventListener() {

    @Override
    public void onBrowserEvent(Event event) {

        switch(event.getTypeInt()) {
            case Event.ONCLICK:
                break;
            case Event.ONMOUSEOVER:
                break;
            case Event.ONMOUSEOUT:
                break;
        }
    }
});