import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.EventQueue;

public class SliderTest {
  public static void main( String[] args ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame(  );
        final JSlider slider = new JSlider( 0, 100 );
        frame.add( slider );
        slider.addChangeListener( new ChangeListener() {
          @Override
          public void stateChanged( ChangeEvent e ) {
            if ( !( slider.getValueIsAdjusting() ) ){
              System.out.println( "SliderTest.stateChanged" );
            }
          }
        } );
        frame.pack();
        frame.setVisible( true );
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
      }
    } );
  }
}