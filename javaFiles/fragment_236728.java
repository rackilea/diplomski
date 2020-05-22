import java.awt.*;
import javax.swing.*;

public class TempProject extends Box{

    public TempProject(){
        super(BoxLayout.Y_AXIS);
        final ProgressMonitor pm = new ProgressMonitor(this, "checking", "...", 0, 100);
        final SwingWorker sw = new SwingWorker<Integer, Integer>()
        {
            protected Integer doInBackground() throws Exception 
            {
                int i = 0;
                //While still doing work and progress  monitor wasn't canceled
                 while (i++ < 100 && !pm.isCanceled()) {
                     System.out.println(i);
                     publish(i);
                     Thread.sleep(100);
                 }
                 return null;
            }


             @Override
             protected void process(java.util.List<Integer> chunks) {
                 for (int number : chunks) {
                     pm.setProgress(number);
                 }
             }

        };

        sw.execute();
    }


    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                frame.setContentPane(new TempProject());    
                frame.pack();
                frame.setVisible(true);
            }
        });
    }   


}