import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class SliderExample2 extends JPanel {
   private JSlider sliderA = new JSlider(JSlider.HORIZONTAL, 0, 20, 5);
   private JSlider sliderB = new JSlider(JSlider.HORIZONTAL, 0, 20, 15);
   private JSlider[] sliders = {sliderA, sliderB};
   private String[] titles = {"Point A", "Point B"};

   private ChangeListener[] changeListeners = {new ChangeListenerA(), 
           new ChangeListenerB()};

   public SliderExample2() {
      for (int i = 0; i < sliders.length; i++) {
         sliders[i].setBorder(BorderFactory.createTitledBorder(titles[i]));
         sliders[i].setMajorTickSpacing(5);
         sliders[i].setMinorTickSpacing(1);
         sliders[i].setPaintTicks(true);
         sliders[i].setPaintLabels(true);             
         sliders[i].addChangeListener(changeListeners[i]);             
         add(sliders[i]);             
      }
   }

   private class ChangeListenerA implements ChangeListener {
      @Override
      public void stateChanged(ChangeEvent cEvt) {
         if (sliderA.getValue() >= sliderB.getValue()) {
            sliderB.setValue(sliderA.getValue() + 1);
         }
      }
   }

   private class ChangeListenerB implements ChangeListener {
      @Override
      public void stateChanged(ChangeEvent cEvt) {
         if (sliderA.getValue() >= sliderB.getValue()) {
            sliderA.setValue(sliderB.getValue() - 1);
         }
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("SliderExample2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new SliderExample2());
      frame.pack();
      frame.setLocationRelativeTo(null);
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