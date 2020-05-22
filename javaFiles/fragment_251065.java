class TreeMouseEventDispatcher implements EventDispatcher {
    private final EventDispatcher originalDispatcher;

    public TreeMouseEventDispatcher(EventDispatcher originalDispatcher) {
      this.originalDispatcher = originalDispatcher;
    }

    @Override
    public Event dispatchEvent(Event event, EventDispatchChain tail) {
        if (event instanceof MouseEvent) {
           if (((MouseEvent) event).getButton() == MouseButton.PRIMARY
               && ((MouseEvent) event).getClickCount() >= 2) {

             if (!event.isConsumed()) {
               // Implement your double-click behavior here, even your
               // MouseEvent handlers will be ignored, i.e., the event consumed!
             }

             event.consume();
           }
        }
        return originalDispatcher.dispatchEvent(event, tail);
    }
}