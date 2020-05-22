treeView.setCellFactory(new Callback<TreeView<T>, TreeCell<T>>() {
  @Override
  public TreeCell<T> call(TreeView<T> param) {
    return new TreeCell<T>() {
      @Override
      protected void updateItem(T item, boolean empty) {
        if (item != null && !empty) {
          EventDispatcher originalDispatcher = getEventDispatcher();
          setEventDispatcher(new TreeMouseEventDispatcher(originalDispatcher));
        }
      }
    };
  }
}