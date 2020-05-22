org.w3c.dom.events.EventListener myModificationListener =
  new org.w3c.dom.events.EventListener() {

    @Override
    public void handleEvent(Event e) {
      if (e instanceof MutationEvent) {
        MutationEvent me = (MutationEvent) e;
        System.out.println("type: " + me.getType()
          + ", dest: " + me.getTarget());
      }
    }

  };

Node someDomNode = ...

// here the unusual casting magic happens
((EventTarget) node).addEventListener(
  "DOMSubtreeModified", // constant
  myModificationListener, true);

// modify the node here by appending a child
// -> listener gets invoked