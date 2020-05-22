import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Test {
   public static void main(String[] args) {
      JFrame frame = new JFrame();
      JPanel p = new JPanel();
      p.setLayout(new FlowLayout());

      PanelOfLabel panelOfLabel = new PanelOfLabel();
      panelOfLabel.setBorder(new LineBorder(Color.red));
      p.add(panelOfLabel);

      PanelOfBoxes panelOfBoxes = new PanelOfBoxes(panelOfLabel); //!!
      panelOfBoxes.setBorder(new LineBorder(Color.green));
      p.add(panelOfBoxes);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400, 400);
      frame.setContentPane(p);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
}

class PanelOfLabel extends JPanel {
   private JLabel[] labels = new JLabel[5];

   public PanelOfLabel() {
      super();
      createLabels();
   }

   public void setLabelVisibility(int index, boolean visible) {
      if (index < 0 || index >= labels.length) {
         throw new ArrayIndexOutOfBoundsException(index);
      }

      labels[index].setVisible(visible);
   }

   public void createLabels() {
      for (int i = 1; i < labels.length; i++) {
         labels[i] = new JLabel();
         labels[i].setText("" + i);
         labels[i].setPreferredSize(new Dimension(25, 25));
         this.add(labels[i]);
      }

   }
}

class PanelOfBoxes extends JPanel {

   private JCheckBox[] checkBoxs = new JCheckBox[5];
   // !! private PanelOfLabel[] PanelOfLabels = new PanelOfLabel[5];
   private PanelOfLabel panelOfLabel; //!!

   public PanelOfBoxes(PanelOfLabel panelOfLabel) {
      super();
      this.panelOfLabel = panelOfLabel; //!!
      createBoxes();
   }

   public void createBoxes() {
      for (int i = 1; i < checkBoxs.length; i++) {
         checkBoxs[i] = new JCheckBox();
         checkBoxs[i].setSelected(true);
         this.add(checkBoxs[i]);
         // !!
         checkBoxs[i].addItemListener(new MyListener(i, panelOfLabel)); //!!
      }
   }
}

class MyListener implements ItemListener {

   private PanelOfLabel panelOfLabels;
   private int index;

   // !!
   public MyListener(int index, PanelOfLabel panelOfLabels) {
      super();
      this.index = index; // !!
      this.panelOfLabels = panelOfLabels;
   }

   @Override //!!
   public void itemStateChanged(ItemEvent e) {
      boolean visible = e.getStateChange() == ItemEvent.SELECTED;
      panelOfLabels.setLabelVisibility(index, visible);
      Container parent = panelOfLabels.getParent();
      parent.repaint();
   }
}