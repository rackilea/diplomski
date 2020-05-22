private class LabelUpdater implements Runnable {
  @Override
  public void run() {
    if( !label.isDisposed() ) {
      label.setText( ... );
      label.getParent().layout();
      display.timerExec( 1000, new LabelUpdater() );
    }
  }
}

shell.addListener( SWT.Activate, new Listener() {
  @Override
  public void handleEvent( Event event ) {
    display.timerExec( 1000, new LabelUpdater() );
  }
} );