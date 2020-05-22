import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;

public class TestMvc {

   private static final int SIZE = 6;

   private static void createAndShowGui() {
      TestModel model = new TestModel(SIZE);
      TestView view = new TestView();
      new TestControl(model, view);

      JFrame frame = new JFrame("TestMvc");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(view.getMainPanel());
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

class TestControl {

   private TestModel model;
   private TestView view;

   public TestControl(final TestModel model, final TestView view) {
      this.model = model;
      this.view = view;
      view.setModel(model);
      TestViewCheckBoxBox checkBoxBox = view.getCheckBoxBox();
      for (int i = 0; i < model.getSize(); i++) {
         checkBoxBox.addCheckBoxItemListener(i, new MyItemListener(i));
      }

      model.addPropertyChangeListener(new ModelPropertyChangeListener());
   }

   private class MyItemListener implements ItemListener {
      private int index;

      public MyItemListener(int index) {
         this.index = index;
      }

      @Override
      public void itemStateChanged(ItemEvent iEvt) {
         model.setValue(index, iEvt.getStateChange() == ItemEvent.SELECTED);
      }
   }

   private class ModelPropertyChangeListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent pcEvt) {
         if (TestModel.VALUE.equals(pcEvt.getPropertyName())) {
            IndexedPropertyChangeEvent ipcEvt = (IndexedPropertyChangeEvent) pcEvt;
            int index = ipcEvt.getIndex();
            boolean visible = (Boolean)ipcEvt.getNewValue();
            view.getLabelBox().setLabelVisible(index, visible);
         }
      }
   }

}

class TestView {
   private JPanel mainPanel = new JPanel();
   private TestModel model;
   private TestViewLabelBox labelBox;
   private TestViewCheckBoxBox checkBoxBox;

   public void setModel(TestModel model) {
      this.model = model;
      mainPanel.setLayout(new GridLayout(1, 0, 5, 0));
      labelBox = new TestViewLabelBox(model.getSize());
      checkBoxBox = new TestViewCheckBoxBox(model.getSize());

      mainPanel.add(labelBox.getMainPanel());
      mainPanel.add(checkBoxBox.getMainPanel());
   }

   public TestViewLabelBox getLabelBox() {
      return labelBox;
   }

   public TestViewCheckBoxBox getCheckBoxBox() {
      return checkBoxBox;
   }

   public JComponent getMainPanel() {
      return mainPanel;
   }

}

class TestViewLabelBox {
   private JPanel mainPanel = new JPanel();
   private List<JLabel> labelList = new ArrayList<>();

   public TestViewLabelBox(int count) {
      mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
      mainPanel.setLayout(new GridLayout(1, 0, 5, 0));
      for (int i = 0; i < count; i++) {
         JLabel label = new JLabel(String.valueOf(i + 1), SwingConstants.CENTER);
         labelList.add(label);
         mainPanel.add(label);
      }
   }

   public void setLabelVisible(int index, boolean visible) {
      if (index < 0 || index >= labelList.size()) {
         throw new ArrayIndexOutOfBoundsException(index);
      }
      String text = visible ? String.valueOf(index + 1) : "";
      labelList.get(index).setText(text);
   }

   public JComponent getMainPanel() {
      return mainPanel;
   }

}

class TestViewCheckBoxBox {
   private JPanel mainPanel = new JPanel();
   private List<JCheckBox> checkBoxList = new ArrayList<>();

   public TestViewCheckBoxBox(int count) {
      mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
      mainPanel.setLayout(new GridLayout(1, 0, 5, 0));
      for (int i = 0; i < count; i++) {
         JCheckBox checkBox = new JCheckBox("", true);
         checkBoxList.add(checkBox);
         mainPanel.add(checkBox);
      }
   }

   public void addCheckBoxItemListener(int index, ItemListener itemListener) {
      if (index < 0 || index >= checkBoxList.size()) {
         throw new ArrayIndexOutOfBoundsException(index);
      }
      checkBoxList.get(index).addItemListener(itemListener);
   }

   public JComponent getMainPanel() {
      return mainPanel;
   }
}

class TestModel {
   public static final String VALUE = "value";
   private List<Boolean> values = new ArrayList<>();
   private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(
         this);

   public TestModel(int size) {
      for (int i = 0; i < size; i++) {
         values.add(Boolean.TRUE);
      }
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(listener);
   }

   public int getSize() {
      return values.size();
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(listener);
   }

   public boolean getValue(int index) {
      if (index < 0 || index >= values.size()) {
         throw new ArrayIndexOutOfBoundsException(index);
      }
      return values.get(index);
   }

   public void setValue(int index, boolean value) {
      if (index < 0 || index >= values.size()) {
         throw new ArrayIndexOutOfBoundsException(index);
      }
      boolean oldValue = getValue(index);
      boolean newValue = value;
      values.set(index, value);
      pcSupport.fireIndexedPropertyChange(VALUE, index, oldValue, newValue);
   }
}