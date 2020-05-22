ISelectionChangedListener listener = new ISelectionChangedListener() {
  @Override
  public void selectionChanged( SelectionChangedEvent event ) {
    IStructuredSelection selection = event.getStructuredSelection();
    List<?> selectedElements = selection.toList();
  }
};