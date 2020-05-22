frame.addComponentListener(new ComponentAdapter(){

 public void componentMoved(ComponentEvent e) {
     if (popup.isVisible()){
         popup.setVisible(false);
     }
  }
  });