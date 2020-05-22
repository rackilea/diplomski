public static void main( String args[] ) {
  Display display = new Display();
  createwindow( display, "http://google.com" );
  createwindow( display, "http://ipchicken.com" );
  while( display.getShells().length > 0 ) {
    if( !display.readAndDispatch() ) {
      display.sleep();
    }
  }
  display.dispose();
}

static void createwindow( Display display, String url ) {
  final Shell shell = new Shell( display );
  shell.setLayout( new FillLayout() );
  Browser browser = new Browser( shell, SWT.NONE );
  browser.setUrl( url );
  shell.open();
  browser.addProgressListener( new ProgressAdapter() {
    @Override
    public void completed( ProgressEvent event ) {
      event.display.timerExec( 3000, new Runnable() {
        @Override
        public void run() {
          shell.close();
        }
      } );
    }
  } );
}