@Override
protected void processMouseMotionEvent(MouseEvent e) {
    if(MouseEvent.MOUSE_DRAGGED != e.getID()) {
        super.processMouseMotionEvent(e);
    }
}