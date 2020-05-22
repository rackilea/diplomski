ISelectionChangedListener listener = new ISelectionChangedListener() {
  @Override
  public void selectionChanged( SelectionChangedEvent event ) {
    IStructuredSelection selection = ( IStructuredSelection )event.getSelection();
    List<?> selectedElements = selection.toList();
  }
};