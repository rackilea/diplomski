button.addSelectionListener( new SelectionAdapter() {
  private int state;
  public void widgetSelected( SelectionEvent event ) {
    state++;
    if( state > 2 ) {
      state = 0;
    }
    Button button = ( Button )event.widget;
    switch( state ) {
      case 0:
        button.setSelection( false );
        button.setGrayed( false );
      break;
      case 1:
        button.setSelection( true );
        button.setGrayed( false );
      break;
      case 2:
        button.setSelection( true );
        button.setGrayed( true );
      break;
    }
  }
} );