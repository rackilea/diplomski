class KeyListeningTool extends KeyAdapter {

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getKeyChar() == ',') {
            evt.setKeyChar('.');
        }
    }
}