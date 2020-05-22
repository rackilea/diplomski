import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Sscce extends JPanel {
   private static final int INITIAL_ROW_COUNT = 100;
   public static final int INCREMENTAL_ADD_ROW_COUNT = 10;
   private static final int MIN_VERT_PERCENT = 4;
   private static final int TIMER_DELAY = 250;
   private ViewportViewPanel viewportViewPanel = new ViewportViewPanel(
         new GridLayout(0, 1));
   private JScrollPane scrollPane = new JScrollPane(viewportViewPanel);
   private BoundedRangeModel vertModel;
   private Timer vertChangeTimer;
   private int viewportViewPanelIndex = 0;
   public Component firstViewedComp;

   public Sscce() {
      setLayout(new BorderLayout());
      add(scrollPane);

      for (viewportViewPanelIndex = 0; viewportViewPanelIndex < INITIAL_ROW_COUNT; viewportViewPanelIndex++) {
         viewportViewPanel.add(new ViewablePanel(viewportViewPanelIndex));
      }

      vertModel = scrollPane.getVerticalScrollBar().getModel();
      vertModel.addChangeListener(new VertModelChangeListener());
   }

   private class VertModelChangeListener implements ChangeListener {

      @Override
      public void stateChanged(ChangeEvent cEvt) {
         // if timer is running, get out of here
         if (vertChangeTimer != null && vertChangeTimer.isRunning()) {
            return;
         }

         // if haven't set firstViewedComp back to null (done in Timer) get out of here
         if (firstViewedComp != null) {
            return;
         }

         // check to see if near bottom
         int diff = vertModel.getMaximum() - vertModel.getValue()
               - vertModel.getExtent();
         int normalizedDiff = (100 * diff) / vertModel.getMaximum();

         // if not near bottom, get out of here
         if (normalizedDiff >= MIN_VERT_PERCENT) {
            return;
         }

         // create and start timer
         vertChangeTimer = new Timer(TIMER_DELAY, new VertChangeTimerListener());
         vertChangeTimer.setRepeats(false);
         vertChangeTimer.start();

         // get viewport and its rectangle
         JViewport viewport = scrollPane.getViewport();
         Rectangle viewRect = viewport.getViewRect();

         // find first component that is inside of viewport's rectangle
         Component[] components = viewportViewPanel.getComponents();
         for (Component component : components) {
            if (viewRect.contains(component.getBounds())) {
               if (firstViewedComp == null) {
                  firstViewedComp = component; // first component found
                  break;
               }
            }
         }

         // delete 10 components at start 
         // add 10 components add end
         for (int i = 0; i < INCREMENTAL_ADD_ROW_COUNT; i++) {
            viewportViewPanel.remove(components[i]);
            viewportViewPanel.add(new ViewablePanel(viewportViewPanelIndex));
            viewportViewPanelIndex++;
         }

         // redo laying out components and repainting the container
         viewportViewPanel.revalidate();
         viewportViewPanel.repaint();

         // scroll back to first viewed component, but give a little delay to allow
         // layout out above to complete. So queue it on the event queue via invokeLater
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               viewportViewPanel.scrollRectToVisible(firstViewedComp
                     .getBounds());
            }
         });

      }
   }

   // the timer listener. it just nulls out the first viewed component
   private class VertChangeTimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         firstViewedComp = null;
      }
   }

   private static void createAndShowGui() {
      Sscce mainPanel = new Sscce();

      JFrame frame = new JFrame("Sscce");
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

// JPanel that is held by the JScrollPane's JViewport and that holds the smaller 
// JPanels. Note that it implements Scrollable
@SuppressWarnings("serial")
class ViewportViewPanel extends JPanel implements Scrollable {
   private static final int BLOCK = 8;

   public ViewportViewPanel(LayoutManager layout) {
      super(layout);
   }

   @Override
   public Dimension getPreferredScrollableViewportSize() {
      int scrollWidth = ViewablePanel.PREF_W;
      int scrollHeight = ViewablePanel.PREF_H * BLOCK;
      return new Dimension(scrollWidth, scrollHeight);
   }

   @Override
   public int getScrollableBlockIncrement(Rectangle visibleRectangle,
         int orientation, int direction) {
      if (orientation == SwingConstants.VERTICAL) {
         return ViewablePanel.PREF_H * (3 * BLOCK) / 4;
      }
      return 0;
   }

   @Override
   public boolean getScrollableTracksViewportHeight() {
      return false;
   }

   @Override
   public boolean getScrollableTracksViewportWidth() {
      return true;
   }

   @Override
   public int getScrollableUnitIncrement(Rectangle visibleRect,
         int orientation, int direction) {
      if (orientation == SwingConstants.VERTICAL) {
         return ViewablePanel.PREF_H;
      }
      return 1;
   }

}

// small JPanel. Many of these are held in a single GridLayout column 
// by the JPanel above.
@SuppressWarnings("serial")
class ViewablePanel extends JPanel {
   public static final int PREF_W = 400;
   public static final int PREF_H = 50;
   private int index;

   public ViewablePanel(int index) {
      this.setIndex(index);
      String title = "index " + index;
      setBorder(BorderFactory.createTitledBorder(title));
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public int getIndex() {
      return index;
   }

   public void setIndex(int index) {
      this.index = index;
   }

}