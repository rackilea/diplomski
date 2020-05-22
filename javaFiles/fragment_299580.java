private final class ClickableHeader extends SimplePanel {

private ClickableHeader() {
  // Anchor is used to allow keyboard access.
  super(DOM.createAnchor());
  Element elem = getElement();
  DOM.setElementProperty(elem, "href", "javascript:void(0);");
  // Avoids layout problems from having blocks in inlines.
  DOM.setStyleAttribute(elem, "display", "block");
  sinkEvents(Event.ONCLICK);
  setStyleName(STYLENAME_HEADER);
}

@Override
public void onBrowserEvent(Event event) {
  // no need to call super.
  switch (DOM.eventGetType(event)) {
    case Event.ONCLICK:
      // Prevent link default action.
      DOM.eventPreventDefault(event);
      setOpen(!isOpen);
  }
}
}