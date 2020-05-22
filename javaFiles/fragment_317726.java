Window.addResizeHandler(new ResizeHandler() {           
  public void onResize(ResizeEvent event) {             
  yourWidget.setHeight(event.getHeight() + "px");
  yourWidget.setWidth(event.getWidth() + "px");
}
});