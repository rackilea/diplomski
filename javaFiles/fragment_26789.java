import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.EventQueue;

public class JSpinnerDemo {

  public static JFrame createFrame(){
    JFrame frame = new JFrame(  );
    frame.add( createSpinner() );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.pack();

    return frame;
  }

  public static JSpinner createSpinner(){
    JSpinner spinner = new JSpinner( new SpinnerNumberModel( 2,1,7,1 ) );
    spinner.addChangeListener( new ChangeListener() {
      @Override
      public void stateChanged( ChangeEvent e ) {
        JSpinner spinner = ( JSpinner ) e.getSource();
        SpinnerModel spinnerModel = spinner.getModel();
        System.out.println(spinnerModel.getValue());
      }
    } );
    return spinner;
  }
  public static void main( String[] args ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        createFrame().setVisible( true );
      }
    } );
  }
}