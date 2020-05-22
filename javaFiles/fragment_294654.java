add(new Label("msg", messageModel)) {
  @Override protected void onConfigure() {
    super.onConfigure();
    setVisible(!messageModel.getObject().equals(message));
  }
};