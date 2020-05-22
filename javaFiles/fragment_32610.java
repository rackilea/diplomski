import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ColoredWordsExperiment extends JPanel {
   Timer timer;
   Timer timer1;
   TimerAction timeraction;
   TimerAction1 timeraction1;
   private int counter;
   private int counter1;
   private JButton button1;
   private JButton button3;
   private ButtonHandler buttonHandler;
   private JLabel counterLabel = new JLabel("   ");
   private JLabel counter1Label = new JLabel("   ");

   ColoredWordsExperiment() {
      button1 = new JButton("Matching");
      button3 = new JButton("Finished");

      buttonHandler = new ButtonHandler(this);
      button1.addActionListener(buttonHandler);
      button3.addActionListener(buttonHandler);

      counter = 0;
      timeraction = new TimerAction(this);
      timer = new Timer(1000, timeraction);
      timer.setInitialDelay(1000);

      counter1 = 0;
      timeraction1 = new TimerAction1(this);
      timer1 = new Timer(1000, timeraction1);
      timer1.setInitialDelay(1000);

      add(button1);
      add(button3);
      add(new JLabel("Counter:"));
      add(counterLabel);
      add(new JLabel("Counter1:"));
      add(counter1Label);

   }

   public int getCounter() {
      return counter;
   }


   public void setCounter(int counter) {
      this.counter = counter;
      counterLabel.setText(String.valueOf(counter));
   }


   public int getCounter1() {
      return counter1;
   }


   public void setCounter1(int counter1) {
      this.counter1 = counter1;
      counter1Label.setText(String.valueOf(counter1));
   }


   private static void createAndShowGui() {
      ColoredWordsExperiment mainPanel = new ColoredWordsExperiment();

      JFrame frame = new JFrame("Colored Words Experiment");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

class ButtonHandler implements ActionListener {
   ColoredWordsExperiment coloredWords;

   public ButtonHandler(ColoredWordsExperiment coloredWords) {
      this.coloredWords = coloredWords;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // if button1 pressed
      if (e.getActionCommand().equals("Matching")) {
         coloredWords.timer.start();
         coloredWords.timer1.start();
         // if button3 pressed
      } else if (e.getActionCommand().equals("Finished")) {
         coloredWords.timer.stop();
         //!! coloredWords.counter = 0;
         coloredWords.setCounter(0); //!! 
         coloredWords.timer1.stop();
      }
   }
}

class TimerAction implements ActionListener {
   ColoredWordsExperiment coloredWords;

   public TimerAction(ColoredWordsExperiment coloredWords) {
      this.coloredWords = coloredWords;
   }

   @Override
   public void actionPerformed(ActionEvent event) {
      coloredWords.setCounter(coloredWords.getCounter() + 1);
      //!! coloredWords.counter++;
   }

}

class TimerAction1 implements ActionListener {
   ColoredWordsExperiment coloredWords;

   public TimerAction1(ColoredWordsExperiment coloredWords) {
      this.coloredWords = coloredWords;
   }

   @Override
   public void actionPerformed(ActionEvent event) {
      //!! coloredWords.counter1++;
      coloredWords.setCounter1(coloredWords.getCounter1() + 1);
   }

}