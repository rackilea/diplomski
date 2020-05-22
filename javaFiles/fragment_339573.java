class MyWidget extends Widget {
    public MyWidget() {
        setElement(DOM.createDiv());
        sinkEvents(Event.ONCLICK);
    }

    public void onBrowserEvent(Event evt) {
        switch (DOM.eventGetType(evt)) {
            case Event.ONCLICK:
                // Do something insightful.
                break;
        }
    }
}