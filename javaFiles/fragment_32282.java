import java.awt.*;
import java.awt.event.*;
import java.beans.*;

import javax.swing.*;

//!! no need to implement PropertyChangeListener
//!! public class ProgressBarTest implements PropertyChangeListener {
public class ProgressBarTest2 {
   private JFrame frame;
   private JButton btnRun;

   // !! this shouldn't be static!
   // !! static JProgressBar progressBar = new JProgressBar(0, 100);
   private JProgressBar progressBar = new JProgressBar(0, 100); // !!

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               UIManager
                     .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
               ProgressBarTest2 window = new ProgressBarTest2();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public ProgressBarTest2() {
      initialize();
   }

   private void initialize() {
      frame = new JFrame();
      // !!frame.setBounds(100, 100, 450, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //!! frame.getContentPane().setLayout(null); //!! never use null layouts
      frame.setResizable(false);

      // !! don't create a shadowed variable
      // !! JProgressBar progressBar = new JProgressBar();

      progressBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
      //!! progressBar.setBounds(0, 252, 444, 20);
      progressBar.setStringPainted(true);
      //!! frame.getContentPane().add(progressBar);
      frame.getContentPane().add(progressBar, BorderLayout.SOUTH);
      btnRun = new JButton("Start Long Run"); //!! no shadowing
      //!! btnRun.setBounds(167, 214, 159, 31);
      JPanel panel = new JPanel(); //!!
      panel.setPreferredSize(new Dimension(450, 300)); //!!
      panel.setLayout(new GridBagLayout()); //!!
      panel.add(btnRun); //!!
      frame.getContentPane().add(panel, BorderLayout.CENTER); //!!
      btnRun.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            longRun();
         }
      });

      //!!
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   private void longRun() {
    //!! use a more realistic value, one that should show change in listener
      //!! LongRunner longRunner = new LongRunner(100000);
      LongRunner2 longRunner = new LongRunner2(10000);  
      longRunner.addPropertyChangeListener(new PropertyChangeListener() {
         @Override
         public void propertyChange(PropertyChangeEvent evt) {
            if ("progress".equals(evt.getPropertyName())) {
               int progress = (int) evt.getNewValue();
               System.out.println("Value in propertyChangeListener: "
                     + progress);
               progressBar.setValue(progress);
            }
         }
      });
      longRunner.execute();
   }

   // !! @Override // !! not needed
   // public void propertyChange(PropertyChangeEvent evt) {
   // }
}

class LongRunner2 extends SwingWorker<Integer, Double> {
   private static final long SLEEP_TIME = 15; // !!
   int numOfPoints;
   double progress;

   public LongRunner2(int numOfPoints) {
      this.numOfPoints = numOfPoints;
      this.progress = 0;
   }

   private void runLong(int bigNum) {
      for (int i = 0; i < bigNum; i++) {
         try {
            // !! quicker turn-over so that our bigNum can change
            // in a realistic way
            // !! Thread.sleep(100);
            Thread.sleep(SLEEP_TIME);// !!
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         progress = (((double) i * 100) / (double) bigNum);
         setProgress((int) progress);
         // !! System.out.println("Value in setProgress: " + progress); //!! This will slow us down
      }
   }

   @Override
   protected Integer doInBackground() throws Exception {
      runLong(numOfPoints);
      return null;
   }
}