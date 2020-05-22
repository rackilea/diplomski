final Element desc = Document.get().createLIElement();
SpanElement spanElement = Document.get().createSpanElement();
spanElement.setInnerHTML("Hello");

desc.appendChild(spanElement);

DOM.sinkEvents((com.google.gwt.user.client.Element) desc, Event.ONCLICK | Event.ONMOUSEOVER);
DOM.setEventListener((com.google.gwt.user.client.Element) desc, new EventListener() {
    @Override
    public void onBrowserEvent(Event e) {
        switch (DOM.eventGetType(e)) {
            case Event.ONCLICK:
                System.out.println("click");
                break;
            case Event.ONMOUSEOVER:
                System.out.println("hover");
                break;
        }
    }
});