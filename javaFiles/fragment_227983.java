public class CopyArea {

  public static void main( String[] args ) {
    CopyArea copyArea = new CopyArea();
    copyArea.create();
    copyArea.run();
  }

  private Display display;
  private Image sourceImage;
  private Point canvasSize;
  private Shell shell;
  private Canvas source;
  private Canvas destination;
  private Point snippetOrigin;
  private Image snippet;

  CopyArea() {
    display = new Display();
    sourceImage = new Image( display, getClass().getResourceAsStream( "mona-lisa.jpeg" ) );
    canvasSize = new Point( sourceImage.getBounds().width, sourceImage.getBounds().height );
    shell = new Shell( display );
    source = new Canvas( shell, SWT.NONE );
    destination = new Canvas( shell, SWT.NONE );
  }

  void create() {
    shell.setLayout( new RowLayout() );
    source.setLayoutData( new RowData( canvasSize ) );
    source.addPaintListener( new PaintListener() {
      @Override
      public void paintControl( PaintEvent event ) {
        event.gc.drawImage( sourceImage, 0, 0 );
        if( snippetOrigin != null ) {
          snippet = new Image( display, 40, 40 );
          event.gc.copyArea( snippet, snippetOrigin.x, snippetOrigin.y );
          destination.redraw();
          snippetOrigin = null;
        }
      }
    } );
    source.addMouseListener( new MouseAdapter() {
      @Override
      public void mouseDown( MouseEvent event ) {
        snippetOrigin = new Point( event.x, event.y );
        source.redraw();
      }
    } );
    destination.setLayoutData( new RowData( canvasSize ) );
    destination.addPaintListener( new PaintListener() {
      @Override
      public void paintControl( PaintEvent event ) {
        event.gc.setBackground( display.getSystemColor( SWT.COLOR_WHITE ) );
        event.gc.fillRectangle( event.gc.getClipping() );
        if( snippet != null ) {
          event.gc.drawImage( snippet, 0, 0 );
        }
      }
    } );
  }

  void run() {
    shell.pack();
    shell.open();
    while( !shell.isDisposed() ) {
      if( !display.readAndDispatch() )
        display.sleep();
    }
    display.dispose();
  }
}