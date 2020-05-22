Event.sinkEvents(span, Event.ONCLICK);
Event.setEventListener(span, new EventListener() {

    @Override
    public void onBrowserEvent(Event event) {
        if(Event.ONCLICK == event.getTypeInt()) {
            //do your on click action
        }
    }
});