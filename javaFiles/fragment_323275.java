Labe label = new Label( ... );
label.setData( "milesone", milestone );
label.addDragListener ( new DragSourceListener () {
  @Override
  public void dragSetData( DragSourceEvent event ) {
    event.data = ( Milestone )event.widget.getData( "milestone" );
  }
  @Override
  public void dragFinished( DragSourceEvent event ) {
    // mark the milestone label as 'assigned' if desired
  }
} );