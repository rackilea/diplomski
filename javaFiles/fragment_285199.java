ListCellRenderer<? super String> renderer = getRenderer();
setRenderer(new ListCellRenderer<String>() {
  @Override public Component getListCellRendererComponent(
      JList<? extends String> list, String value, int index,
      boolean isSelected, boolean cellHasFocus) {
    Component c = renderer.getListCellRendererComponent(
      list, value, index, isSelected, cellHasFocus);