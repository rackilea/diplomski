MouseListener ml = new MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        chatInputMouseClicked(evt);
    }
};
chatInput.addMouseListener (ml);
...
chatInput.removeMouseListener (ml);