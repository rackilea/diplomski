public void widgetSelected(SelectionEvent e) {
  Widget selectedItem = (e.item != null) ? e.item : e.getSource();
  if (selectedItem  == openMenu) {
    open();
  else if(selectedItem == closeMenu) {
    close();
  }
}