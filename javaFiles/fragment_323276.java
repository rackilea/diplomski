Label label = new Label( ... );
label.setData( "square", square );
label.addDropListener ( new DropTargetAdapter() {
  @Override
  public void drop( DropTargetEvent event ) {
    if( event.data == null ) {
      event.detail = DND.DROP_NONE;
    } else {
      Milestone milestone = ( Milestone )event.data;
      Square square = event.widget.getData( "square" );
      milestone.setPositionId( square.getId() ); // or whatever it takes to update the model
      // update label text if necessary
    }
  }