public static void main( String[] args ) {
  Display display = new Display();
  final Shell shell = new Shell( display );
  shell.setLayout( new FillLayout() );
  final CTabFolder folder = new CTabFolder( shell, SWT.BORDER );
  for( int i = 0; i < 4; i++ ) {
    CTabItem item = new CTabItem( folder, SWT.CLOSE );
    item.setText( "Item " + i );
    Text text = new Text( folder, SWT.MULTI );
    text.setText( "Content for Item " + i );
    item.setControl( text );
  }
  Listener dragListener = new Listener() {
    private CTabItem dragItem;

    public void handleEvent( Event event ) {
      Point mouseLocation = new Point( event.x, event.y );
      switch( event.type ) {
        case SWT.DragDetect: {
          CTabItem item = folder.getItem( mouseLocation );
          if( dragItem == null && item != null ) {
            dragItem = item;
            folder.setCapture( true );
          }
          break;
        }
        case SWT.MouseUp: {
          if( dragItem != null && !folder.getBounds().contains( mouseLocation ) ) {
            popOut( dragItem, folder.toDisplay( mouseLocation ) );
            dragItem.dispose();
            dragItem = null;
          }
          break;
        }
      }
    }
  };
  folder.addListener( SWT.DragDetect, dragListener );
  folder.addListener( SWT.MouseUp, dragListener );
  shell.pack();
  shell.open();
  while( !shell.isDisposed() ) {
    if( !display.readAndDispatch() )
      display.sleep();
  }
  display.dispose();
}

private static void popOut( CTabItem tabItem, Point location ) {
  Control control = tabItem.getControl();
  tabItem.setControl( null );
  Shell itemShell = new Shell( tabItem.getParent().getShell(), SWT.DIALOG_TRIM | SWT.RESIZE );
  itemShell.setLayout( new FillLayout() );
  control.setParent( itemShell );
  control.setVisible( true ); // control is hidden by tabItem.setControl( null ), make visible again
  itemShell.pack();
  itemShell.setLocation( location );
  itemShell.open();
}