import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;

public class ColorListenerPanel extends JPanel {
   public ColorListenerPanel() {
      UIPanel uiPanel = new UIPanel();
      MainPanel mainPanel = new MainPanel(uiPanel);

      setLayout(new BorderLayout());
      add(mainPanel, BorderLayout.CENTER);
      add(uiPanel, BorderLayout.PAGE_START);
   }

   private static void createAndShowGui() {
      ColorListenerPanel mainPanel = new ColorListenerPanel();

      JFrame frame = new JFrame("ColorListenerPanel");
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

class MainPanel extends JPanel {
   private static final int PREF_W = 800;
   private static final int PREF_H = 650;
   private static final int OVAL_WIDTH = 16;
   private int px, py;
   private Color color = MyColors.values()[0].getColor();

   public MainPanel(UIPanel uiPanel) {

      this.addMouseMotionListener(new MouseMotionAdapter() {
         // store drag coordinates and repaint
         public void mouseDragged(MouseEvent event) {
            px = event.getX();
            py = event.getY();
            repaint();
         }
      });

      uiPanel.addPropertyChangeListener(UIPanel.COLOR, new UiListener());
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g.setColor(color);
      g.fillOval(px - OVAL_WIDTH / 2, py - OVAL_WIDTH / 2, OVAL_WIDTH, OVAL_WIDTH);
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class UiListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent pcEvt) {
         // not really needed since our listener is added using
         // this property name
         if (!UIPanel.COLOR.equals(pcEvt.getPropertyName())) {
            return;
         }

         color = (Color) pcEvt.getNewValue();
         repaint();
      }
   }
}



enum MyColors {
   RED("Red", Color.RED), 
   BLUE("Blue", Color.BLUE), 
   YELLOW("Yellow", Color.YELLOW), 
   GREEN("Green", Color.GREEN);

   private String name;
   private Color color;

   private MyColors(String name, Color color) {
      this.name = name;
      this.color = color;
   }

   public String getName() {
      return name;
   }

   public Color getColor() {
      return color;
   }

   @Override
   public String toString() {
      return name;
   }

}

class UIPanel extends JPanel {
   public static final String COLOR = "color";
   private MainPanel gpanel;
   private Integer data;
   private Color color;
   private DefaultComboBoxModel<MyColors> comboModel = new DefaultComboBoxModel<>();
   private JComboBox<MyColors> colorsCombo = new JComboBox<>(comboModel);
   SetColorAction setColorAction = new SetColorAction("Set", KeyEvent.VK_S);

   public UIPanel() {
      setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
      add(colorsCombo);
      add(Box.createHorizontalStrut(5));
      add(new JButton(setColorAction));
      colorsCombo.addActionListener(setColorAction);
      add(Box.createHorizontalGlue());

      for (MyColors myColor : MyColors.values()) {
         comboModel.addElement(myColor);
      }
   }

   public void setColor(Color color) {
      Color oldValue = this.color;
      Color newValue = color;
      this.color = color;
      firePropertyChange(COLOR, oldValue, newValue);
   }

   private class SetColorAction extends AbstractAction {

      public SetColorAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         MyColors selection = (MyColors) colorsCombo.getSelectedItem();
         if (selection != null) {
            setColor(selection.getColor());            
         }
      }
   }
}