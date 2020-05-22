NativeMouseAdapter adapter = new NativeMouseAdapter(){
    public void nativeMouseClicked(NativeMouseEvent e){
          pixelChoose(pix[tmp]);
          setState(Frame.NORMAL);
          GlobalScreen.removeNativeMouseListener(this);
    }
};
MouseListener listener = new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
          setState(Frame.ICONIFIED);
          GlobalScreen.addNativeMouseListener(adapter);
    }
};
pix[i].addMouseListener(listener);