// This method minimizes a frame; the iconified bit is not affected
public void maximize(Frame frame) {
    int state = frame.getExtendedState();

    // Set the maximized bits
    state |= Frame.MAXIMIZED_BOTH;

    // Maximize the frame
    frame.setExtendedState(state);
}