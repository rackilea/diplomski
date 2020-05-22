listModel.addListDataListener( new ListDataListener() {      
  public void intervalAdded(ListDataEvent e) {
     updateLabel();
  }

  public void intervalRemoved(ListDataEvent e) {
     updateLabel();
  }

  public void contentsChanged(ListDataEvent e) {
     updateLabel();
  }
});