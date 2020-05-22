final Element link = DOM.createAnchor();
final Element th = DOM.createTH();
link.setInnerText("my link");
link.setAttribute("style", "cursor:pointer;");
DOM.sinkEvents(link, Event.ONCLICK);
DOM.setEventListener(link, new EventListener() {
      public void onBrowserEvent(Event event) {
          Window.alert("Clicked!");     
      }
});
th.appendChild(link);