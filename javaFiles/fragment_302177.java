import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import java.util.List;

/**
 * Created on 13.06.17.
 */
public class DialogJunker {
    static class ProgressDialog extends JDialog {
        JProgressBar bar;
        ProgressDialog(){
            setModal(true);
            bar = new JProgressBar();
            add(bar);
            pack();
        }
        void setProgress(int i){
            bar.setValue(i);
        }
    }
    public static void main(String[] args){

        JFrame frame = new JFrame("diddly dialog");
        JButton button = new JButton("start");
        button.addActionListener(evt->{
            ProgressDialog log = new ProgressDialog();

            new SwingWorker<Void, Integer>(){
                @Override
                public Void doInBackground(){
                    for(int i = 0; i<100; i++){
                        try{
                            Thread.sleep(10);
                            publish(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    return null;
                }
                @Override
                public void done(){
                    log.setVisible(false);
                    log.dispose();
                }
                @Override
                protected void process(List<Integer> ints){
                    log.setProgress(ints.get(0));
                }


            }.execute();

            log.setVisible(true);

        });
        frame.add(button);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}