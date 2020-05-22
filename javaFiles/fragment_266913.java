tabPanel.addSelectionHandler(new SelectionHandler<Integer>(){
  public void onSelection(SelectionEvent<Integer> event){
   int tabId = event.getSelectedItem();
   Widget tabWidget = tabpanel.getWidget(tabId);
 }
});