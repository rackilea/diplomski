private class LabelUpdater implements Runnable {
  @Override
  public void run() {
    if( !label.isDisposed() ) {
      label.setText( ... );
      label.getParent().layout();
    }
  }
}

Runnable runnable = new Runnable() {
  @Override
  public void run() {
    while( !shell.isDisposed() ) {
      display.asyncExec( new LabelUpdater() );
      try {
        Thread.sleep( 1000 );
      } catch( InterruptedException ignore ) {
        Thread.interrupted();
      }
    }
  }
};
Thread thread = new Thread( runnable );
thread.setDaemon( true );
thread.start();