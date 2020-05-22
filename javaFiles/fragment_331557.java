public void actionPerformed(ActionEvent arg0) {
  AWTEvent evt = EventQueue.getCurrentEvent();
  if (evt instanceof MouseEvent) {
    MouseEvent me = (MouseEvent) evt;
  }
}