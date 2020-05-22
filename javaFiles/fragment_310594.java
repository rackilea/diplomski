public class FxSwingFx extends Application {

   JInternalFrame createInternalFrame( String title, int width, int height ) {
      final JInternalFrame frame = new JInternalFrame( title, true, true, true, true );
      frame.setVisible( true );
      frame.setSize( width, height );
      return frame;
   }

   void createSwing( SwingNode swingNode ) {
      final JDesktopPane desktopPane = new JDesktopPane();
      desktopPane.add( createInternalFrame( "One", 400, 300 ));
      desktopPane.add( createInternalFrame( "Two", 400, 300 ));
      swingNode.setContent( desktopPane );
   }

   @Override
   public void start( Stage primaryStage ) throws Exception {
      final SwingNode swingNode = new SwingNode();
      SwingUtilities.invokeLater(() -> createSwing( swingNode ));
      final BorderPane root = new BorderPane( swingNode );
      final Button jfxBtn = new Button( "FX Button" );
      root.setBottom( jfxBtn );
      primaryStage.setScene( new Scene( root, 600, 500 ));
      primaryStage.show();
   }

   public static void main( String[] args ) {
      launch( args );
   }
}