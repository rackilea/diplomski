import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddToJListDemo {

  private static JFrame createGUI(){
    JFrame frame = new JFrame(  );

    final DefaultListModel model = new DefaultListModel();
    JList list = new JList( model );

    final JTextField input = new JTextField( 10 );
    input.addActionListener( new ActionListener() {
      public void actionPerformed( ActionEvent aActionEvent ) {
        String text = input.getText();
        if ( text.length() > 0 ) {
          model.addElement( text );
          input.setText( "" );
        }
      }
    } );

    frame.add( list, BorderLayout.CENTER );
    frame.add( input, BorderLayout.SOUTH );

    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    return frame;
  }

  public static void main( String[] args ) {
    EventQueue.invokeLater( new Runnable() {
      public void run() {
        JFrame frame = createGUI();
        frame.setSize( 200,200 );
        frame.setVisible( true );
      }
    } );
  }
}