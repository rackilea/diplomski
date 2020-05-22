import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TextAreaDemo {

  public static void main( String[] args ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        JFrame testFrame = new JFrame( "TestFrame" );

        final JTextArea textArea = new JTextArea( 15, 65 );
        testFrame.add( new JScrollPane( textArea ) );

        final JCheckBox wordWrap = new JCheckBox( "word wrap" );
        wordWrap.setSelected( textArea.getWrapStyleWord() );
        wordWrap.addItemListener( new ItemListener() {
          @Override
          public void itemStateChanged( ItemEvent e ) {
            textArea.setWrapStyleWord( wordWrap.isSelected() );
          }
        } );
        testFrame.add( wordWrap, BorderLayout.NORTH );
        final JCheckBox lineWrap = new JCheckBox( "line wrap" );
        lineWrap.setSelected( textArea.getLineWrap() );
        lineWrap.addItemListener( new ItemListener() {
          @Override
          public void itemStateChanged( ItemEvent e ) {
            textArea.setLineWrap( lineWrap.isSelected() );
          }
        } );
        testFrame.add( lineWrap, BorderLayout.SOUTH );

        testFrame.pack();
        testFrame.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        testFrame.setVisible( true );
      }
    } );

  }
}