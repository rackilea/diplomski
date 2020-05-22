AWTInputHandler wwHandler = null;
// get World Wind's AWTInputHandler class:
for (MouseMotionListener l : ww.getMouseMotionListeners()) {
    if(l instanceof AWTInputHandler) {
        wwHandler = (AWTInputHandler)l;
        break;
    }
}