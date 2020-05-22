import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class SwapPanelEg extends JPanel {
   private static final long serialVersionUID = 1594039652438249918L;
   private static final int PREF_W = 400;
   private static final int PREF_H = 400;
   private static final int MAX_COLUMN_PANELS = 8;
   private JPanel columnPanelsHolder = new JPanel();

   public SwapPanelEg() {
      columnPanelsHolder.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      for (int i = 0; i < MAX_COLUMN_PANELS; i++) {
         int number = i + 1;
         int width = 20 + i * 3;
         int height = PREF_H - 30;
         columnPanelsHolder.add(new ColumnPanel(number, width, height));
      }

      MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
      columnPanelsHolder.addMouseListener(myMouseAdapter);
      columnPanelsHolder.addMouseMotionListener(myMouseAdapter);

      setLayout(new GridBagLayout());
      add(columnPanelsHolder);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private class MyMouseAdapter extends MouseAdapter {
      private JComponent selectedPanel;
      private Point deltaLocation;
      private JLabel placeHolder = new JLabel();
      private JComponent glassPane;

      @Override
      public void mousePressed(MouseEvent evt) {
         if (evt.getButton() != MouseEvent.BUTTON1) {
            return;
         }
         JPanel source = (JPanel) evt.getSource();
         selectedPanel = (JComponent) source.getComponentAt(evt.getPoint());

         if (selectedPanel == null) {
            return;
         }

         if (selectedPanel == source) {
            selectedPanel = null;
            return;
         }

         glassPane = (JComponent) SwingUtilities.getRootPane(source).getGlassPane();
         glassPane.setVisible(true);
         Point glassPaneOnScreen = glassPane.getLocationOnScreen();
         glassPane.setLayout(null);
         Point ptOnScreen = evt.getLocationOnScreen();
         Point panelLocOnScreen = selectedPanel.getLocationOnScreen();

         int deltaX = ptOnScreen.x + glassPaneOnScreen.x - panelLocOnScreen.x;
         int deltaY = ptOnScreen.y + glassPaneOnScreen.y - panelLocOnScreen.y;

         deltaLocation = new Point(deltaX, deltaY);

         Component[] allComps = source.getComponents();
         for (Component component : allComps) {
            source.remove(component);
            if (component == selectedPanel) {
               placeHolder.setPreferredSize(selectedPanel.getPreferredSize());
               source.add(placeHolder);
               selectedPanel.setSize(selectedPanel.getPreferredSize());
               int x = ptOnScreen.x - deltaLocation.x;
               int y = ptOnScreen.y - deltaLocation.y;
               selectedPanel.setLocation(x, y);
               glassPane.add(selectedPanel);
            } else {
               source.add(component);
            }
         }
         revalidate();
         repaint();

      }

      @Override
      public void mouseDragged(MouseEvent evt) {
         if (selectedPanel != null) {
            Point ptOnScreen = evt.getLocationOnScreen();

            int x = ptOnScreen.x - deltaLocation.x;
            int y = ptOnScreen.y - deltaLocation.y;
            selectedPanel.setLocation(x, y);
            repaint();
         }
      }

      @Override
      public void mouseReleased(MouseEvent evt) {
         if (evt.getButton() != MouseEvent.BUTTON1) {
            return;
         }
         if (selectedPanel == null) {
            return;
         }

         JComponent source = (JComponent) evt.getSource();

         Component[] allComps = source.getComponents();
         Component overComponent = (JComponent) source.getComponentAt(evt
               .getPoint());

         source.removeAll();

         if (overComponent != null && overComponent != placeHolder
               && overComponent != source) {
            for (Component component : allComps) {
               if (component == placeHolder) {
                  source.add(overComponent);
               } else if (component == overComponent) {
                  source.add(selectedPanel);
               } else {
                  source.add(component);
               }
            }
         } else {
            for (Component component : allComps) {
               if (component == placeHolder) {
                  source.add(selectedPanel);
               } else {
                  source.add(component);
               }
            }
         }
         revalidate();
         repaint();
         selectedPanel = null;
      }
   }

   private static void createAndShowGui() {
      SwapPanelEg mainPanel = new SwapPanelEg();

      JFrame frame = new JFrame("SwapPanelEg");
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

class ColumnPanel extends JPanel {
   private static final long serialVersionUID = 5366233209639059032L;
   private int number;
   private int prefWidth;
   private int prefHeight;

   public ColumnPanel(int number, int prefWidth, int prefHeight) {
      setName("ColumnPanel " + number);
      this.number = number;
      this.prefWidth = prefWidth;
      this.prefHeight = prefHeight;

      add(new JLabel(String.valueOf(number)));
      setBorder(BorderFactory.createLineBorder(Color.black));
      setBackground(Color.cyan);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(prefWidth, prefHeight);
   }

   public int getNumber() {
      return number;
   }

}