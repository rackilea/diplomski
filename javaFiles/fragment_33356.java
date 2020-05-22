import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateOptionPane {

  private static void showUI(){
    final JFrame testFrame = new JFrame( "TestFrame" );

    final JTextArea textArea = new JTextArea(  );
    testFrame.add( new JScrollPane( textArea ), BorderLayout.CENTER );

    Timer timer = new Timer( 1000, new ActionListener() {
      @Override
      public void actionPerformed( ActionEvent e ) {
        textArea.append( "bla" );
      }
    } );
    timer.setRepeats( true );
    timer.start();
    JButton button = new JButton( "Click me" );
    button.addActionListener( new ActionListener() {
      @Override
      public void actionPerformed( ActionEvent e ) {
        System.out.println("Before option pane");
        JOptionPane.showMessageDialog( testFrame, "A message dialog" );
        System.out.println("After option pane");
      }
    } );
    testFrame.add( button, BorderLayout.SOUTH );
    testFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    testFrame.pack();
    testFrame.setVisible( true );
  }

  public static void main( String[] args ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        showUI();
      }
    } );
  }
}