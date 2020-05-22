private MouseListener mouseListener;
MainClass1() {
   mouseListener = createMouseListener();
   addMouseListener(mouseListener);
}

protected MouseListener createMouseListener() {
    MouseListener l = new MouseListener() {

    }
   return l;
}