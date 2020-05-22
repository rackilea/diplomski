import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class DragAndDropTester {
  private static final JLabel TEST_LABEL = new JLabel( "TestLabel" );

  public static void main( String[] args ) {
    try {
      EventQueue.invokeAndWait( new Runnable() {
        public void run() {

          JFrame testFrame = new JFrame( "Test" );

          JPanel contents = new JPanel( new BorderLayout() );
          contents.add( TEST_LABEL, BorderLayout.CENTER );

          contents.setTransferHandler( createTransferHandler() );

          testFrame.getContentPane().add( contents );
          testFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
          testFrame.setSize( 200, 200 );
          testFrame.setVisible( true );
        }
      } );
    } catch ( InterruptedException e ) {
    } catch ( InvocationTargetException e ) {
    }
  }

  private static TransferHandler createTransferHandler(){
    return new TransferHandler(  ){
      @Override
      public boolean importData( JComponent comp, Transferable aTransferable ) {
        try {
          Object transferData = aTransferable.getTransferData( DataFlavor.imageFlavor );
          TEST_LABEL.setIcon( new ImageIcon( ( Image ) transferData ) );
        } catch ( UnsupportedFlavorException e ) {
        } catch ( IOException e ) {
        }
        return true;
      }

      @Override
      public boolean canImport( JComponent comp, DataFlavor[] transferFlavors ) {
        return true;
      }
    };
  }
}