import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class UseModelGui {

   private static void createAndShowGui() {
      Panel1 panel1 = new Panel1();
      Panel2 panel2 = new Panel2();
      Model model = new Model();

      panel1.setModel(model);
      panel2.setModel(model);

      JFrame frame = new JFrame("UseModelGui");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(new FlowLayout());
      frame.getContentPane().add(panel1);
      frame.getContentPane().add(panel2);
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

class Panel1 extends JPanel {
   private JTextField scoreField = new JTextField(2);
   private JTextField levelField = new JTextField(2);

   public Panel1() {
      scoreField.setFocusable(false);
      scoreField.setEditable(false);
      levelField.setFocusable(false);
      levelField.setEditable(false);

      add(new JLabel("score:"));
      add(scoreField);
      add(new JLabel("Level:"));
      add(levelField);
      setBorder(BorderFactory.createTitledBorder("Check Values"));
   }

   public void setModel(Model model) {
      model.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent pcEvt) {
            if (Model.LEVEL.equals(pcEvt.getPropertyName())) {
               String level = pcEvt.getNewValue().toString();
               levelField.setText(level);
            } else if (Model.SCORE.equals(pcEvt.getPropertyName())) {
               String score = pcEvt.getNewValue().toString();
               scoreField.setText(score);
            }

         }
      });
   }

}

class Panel2 extends JPanel {
   private JSpinner scoreSpinner = new JSpinner(new SpinnerNumberModel(0, 0,
         20, 1));
   private JSpinner levelSpinner = new JSpinner(new SpinnerNumberModel(0, 0,
         10, 1));
   private Model model;

   public Panel2() {
      add(new JLabel("score:"));
      add(scoreSpinner);
      add(new JLabel("Level:"));
      add(levelSpinner);
      setBorder(BorderFactory.createTitledBorder("Set Values"));

      scoreSpinner.addChangeListener(new ChangeListener() {

         @Override
         public void stateChanged(ChangeEvent evt) {
            int score = ((Integer) scoreSpinner.getValue()).intValue();
            if (model != null) {
               model.setScore(score);
            }
         }
      });
      levelSpinner.addChangeListener(new ChangeListener() {

         @Override
         public void stateChanged(ChangeEvent evt) {
            int level = ((Integer) levelSpinner.getValue()).intValue();
            if (model != null) {
               model.setLevel(level);
            }
         }
      });
   }

   public void setModel(Model model) {
      this.model = model;
   }

}