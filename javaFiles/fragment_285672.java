treeViewer.getTree().addListener( SWT.DefaultSelection, new Listener() {
  @Override
  public void handleEvent( Event event ) {
    TreeItem treeItem = ( TreeItem )event.item;
    Point cursorLocation = event.display.getCursorLocation();
    Point localCursorLocation = treeItem.getParent().toControl( cursorLocation );
    if( treeItem.getBounds().contains( localCursorLocation ) ) {
      // put your JFace expand/collapse code here
    }
  }
} );