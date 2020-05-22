list.addListener( SWT.MouseDown, new Listener() {
  @Override
  public void handleEvent( Event event ) {
    int itemTop = 0;
    for( int i = 0; i < list.getItemCount(); i++ ) {
      if( event.y >= itemTop && event.y <= itemTop + list.getItemHeight() ) {
        System.out.println( "Click on item " + list.getItem( list.getTopIndex()  + i ) );
      }
      itemTop += list.getItemHeight();
    }
  }
} );