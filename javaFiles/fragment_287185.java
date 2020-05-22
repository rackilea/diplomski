this.editable = editable;
if (editable) {
    this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    super.enableEvents(Event.MOUSE_DOWN | Event.MOUSE_UP);
} else {
    this.setCursor(CursorFactory.createUnavailableCursor());
    super.disableEvents(Event.MOUSE_DOWN | Event.MOUSE_UP);
}