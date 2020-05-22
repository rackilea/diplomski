Browser browser = new Browser( shell, SWT.NONE );
browser.addProgressListener( new ProgressAdapter() {
  @Override
  public void completed( ProgressEvent event ) {
    String text = browser.getText();
    // here, text will contain the full page source
  }
} );
browser.setUrl( "http://eclipse.org" );