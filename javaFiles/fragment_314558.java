private boolean mouseListenerIsActive;

public void doSmthWithMouseListeners () {
    mouseListenerIsActive = true;

    chatInput.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) {
            if (mouseListenerIsActive) {
               chatInputMouseClicked(evt);
            }
        }
    });
}

public void stopMouseListner () {
    mouseListenerIsActive = false;
}