public static void main( String[] args ) {
  Display display = new Display();
  Shell shell = new Shell( display );
  shell.setLayout( new FillLayout() );
  ScrolledComposite scrolled = new ScrolledComposite( shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL );
  scrolled.setExpandVertical( true );
  scrolled.setExpandHorizontal( true );
  scrolled.setAlwaysShowScrollBars( true );
  Composite composite = new Composite( scrolled, SWT.NONE );
  composite.setLayout( new FillLayout( SWT.VERTICAL ) );
  for( int i = 0; i < 6; i++ ) {
    Composite item = new Composite( composite, SWT.NONE );
    item.setBackground( item.getDisplay().getSystemColor( SWT.COLOR_BLACK + i ) );
  }
  scrolled.setContent( composite );
  scrolled.setMinSize( composite.computeSize( SWT.DEFAULT, SWT.DEFAULT ) );
  scrolled.addControlListener( new ControlAdapter() {
    public void controlResized( ControlEvent event ) {
      Rectangle clientArea = scrolled.getClientArea();
      scrolled.setMinSize( composite.computeSize( clientArea.width, SWT.DEFAULT ) );
    }
  } );
  shell.setSize( 300, 300 );
  shell.open();
  while( !shell.isDisposed() ) {
    if( !display.readAndDispatch() )
      display.sleep();
  }
  display.dispose();
}