import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class LinkedSliders2 extends JPanel {
   private static final int SLIDER_COUNT = 5;
   public static final int SLIDER_MAX_VALUE = 1000;
   private static final int MAJOR_TICK_DIVISIONS = 5;
   private static final int MINOR_TICK_DIVISIONS = 20;
   private static final int LS_WIDTH = 700;
   private static final int LS_HEIGHT = 500;
   private JSlider[] sliders = new JSlider[SLIDER_COUNT];
   private SliderGroup2 sliderGroup = new SliderGroup2(SLIDER_MAX_VALUE);

   public LinkedSliders2() {
      Dictionary<Integer, JComponent> myDictionary = new Hashtable<Integer, JComponent>();
      for (int i = 0; i <= MAJOR_TICK_DIVISIONS; i++) {
         Integer key = i * SLIDER_MAX_VALUE / MAJOR_TICK_DIVISIONS;
         JLabel value = new JLabel(String.valueOf(i * 100 / MAJOR_TICK_DIVISIONS));
         myDictionary.put(key, value);
      }
      setLayout(new GridLayout(0, 1));
      for (int i = 0; i < sliders.length; i++) {
         sliders[i] = new JSlider(0, SLIDER_MAX_VALUE, SLIDER_MAX_VALUE
               / SLIDER_COUNT);
         sliders[i].setLabelTable(myDictionary );
         sliders[i].setMajorTickSpacing(SLIDER_MAX_VALUE / MAJOR_TICK_DIVISIONS);
         sliders[i].setMinorTickSpacing(SLIDER_MAX_VALUE / MINOR_TICK_DIVISIONS);
         sliders[i].setPaintLabels(true);
         sliders[i].setPaintTicks(true);
         sliders[i].setPaintTrack(true);
         sliderGroup.addSlider(sliders[i]);
         add(sliders[i]);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(LS_WIDTH, LS_HEIGHT);
   }

   private static void createAndShowGui() {
      LinkedSliders2 mainPanel = new LinkedSliders2();

      JFrame frame = new JFrame("LinkedSliders");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

class SliderGroup2 {
   private List<BoundedRangeModel> sliderModelList = new ArrayList<BoundedRangeModel>();
   private ChangeListener changeListener = new SliderModelListener();
   private int maxValueSum;

   public SliderGroup2(int maxValueSum) {
      this.maxValueSum = maxValueSum;
   }

   public void addSlider(JSlider slider) {
      BoundedRangeModel model = slider.getModel();
      sliderModelList.add(model);
      model.addChangeListener(changeListener);
   }

   private class SliderModelListener implements ChangeListener {
      private boolean internalChange = false;

      @Override
      public void stateChanged(ChangeEvent cEvt) {
         if (!internalChange) {
            internalChange = true;
            BoundedRangeModel sourceModel = (BoundedRangeModel) cEvt.getSource();
            int sourceValue = sourceModel.getValue();

            int oldSumOfOtherSliders = 0;
            for (BoundedRangeModel model : sliderModelList) {
               if (model != sourceModel) {
                  oldSumOfOtherSliders += model.getValue();
               }
            }
            if (oldSumOfOtherSliders == 0) {
               for (BoundedRangeModel model : sliderModelList) {
                  if (model != sourceModel) {
                     model.setValue(1);
                  }
               }
               internalChange = false;
               return;
            }

            int newSumOfOtherSliders = maxValueSum - sourceValue;

            for (BoundedRangeModel model : sliderModelList) {
               if (model != sourceModel) {
                  long newValue = ((long) newSumOfOtherSliders * model
                        .getValue()) / oldSumOfOtherSliders;
                  model.setValue((int) newValue);
               }
            }

            int total = 0;
            for (BoundedRangeModel model : sliderModelList) {
               total += model.getValue();
            }
            //!! System.out.printf("Total = %.0f%n", (double)total * 100 / LinkedSliders2.SLIDER_MAX_VALUE);

            internalChange = false;
         }
      }

   }

}