public void keyTyped(KeyEvent evt) {
    String keyPressed = new String(""+evt.getKeyChar()).toLowerCase();
    JButton tmp = buttonMap.get(keyPressed);
    if(null != tmp){
        tmp.doClick();
    }
}