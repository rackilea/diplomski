import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class SwingTesting {

  public static void main(String[] args) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame();
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            new GuiWorker().execute();
          }
        });
        button.setText("Test Me");
        frame.getContentPane().add(button);
        frame.pack();
        frame.setVisible(true);
      }
    } );

  }
}

class GuiWorker extends SwingWorker<Integer, Integer> {

  /*
  * This should just create a frame that will hold a progress bar until the
  * work is done. Once done, it should remove the progress bar from the dialog
  * and add a label saying the task complete.
  */

  private JFrame frame = new JFrame();
  private JDialog dialog = new JDialog(frame, "Swingworker test", true);
  private JProgressBar progressBar = new JProgressBar();


  public GuiWorker() {
    progressBar.setString("Waiting on time");
    progressBar.setStringPainted(true);
    progressBar.setIndeterminate(true);
    dialog.getContentPane().add(progressBar);
    dialog.pack();
    dialog.setModal( false );
    dialog.setVisible(true);
  }

  @Override
  protected Integer doInBackground() throws Exception {
    System.out.println( "GuiWorker.doInBackground" );
    Thread.sleep(1000);
    return 0;
  }

  @Override
  protected void done() {
    System.out.println("done");
    JLabel label = new JLabel("Task Complete");
    dialog.getContentPane().remove(progressBar);
    dialog.getContentPane().add(label);
    dialog.getContentPane().validate();
  }

}