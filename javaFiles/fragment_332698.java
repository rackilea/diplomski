import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;

public class TextFieldWithFlowLayout {
  public static void main( String[] args ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        JFrame console = new JFrame("ArchiveConsole");
        Container base  = console.getContentPane();
        base.setLayout(new FlowLayout( FlowLayout.CENTER, 5,5));

        JTextField tf = new JTextField();
        tf.setColumns( 20 );
        base.add(tf);
        console.pack();
        console.setVisible(true);
      }
    } );
  }
}