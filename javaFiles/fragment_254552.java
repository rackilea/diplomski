frameOrPanel.addComponentListener(new ComponentAdapter() {
   public void componentResized(ComponentEvent componentEvent) {
    element.setLocation(frameOrPanel.getWidth()*1/4, frameOrPanel.getHeight*1/4);
    element.setSize(frameOrPanel.getWidth()*1/2, frameOrPanel.getHeight()*1/2);
   }
});