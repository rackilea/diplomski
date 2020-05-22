import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;


@SuppressWarnings("serial")
public class DimmingPanelSwaps extends JPanel {
   private static final int DELTA_TIME = 10;
   private static final int ELAPSED_TIME = 3000;
   private static final String SWAPPING_IMG_PANEL = "swapping img panel";
   private CardLayout cardlayout = new CardLayout();
   private JPanel cardHolderPanel = new JPanel(cardlayout);
   private DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>();
   private JComboBox<String> cardCombo = new JComboBox<>(comboModel);
   private Map<String, JComponent> componentMap = new HashMap<String, JComponent>();
   private String key = "";
   private SwappingImgPanel swappingImgPanel = new SwappingImgPanel(DELTA_TIME, ELAPSED_TIME);

   public DimmingPanelSwaps() {
      registerComponent(createComponentOne(), "one");
      registerComponent(createComponentTwo(), "two");      
      registerComponent(createComponentThree(), "three");
      registerComponent(createComponentFour(), "four");
      key = "one";
      cardHolderPanel.add(swappingImgPanel, SWAPPING_IMG_PANEL);

      JPanel southPanel = new JPanel();
      southPanel.add(cardCombo);

      setLayout(new BorderLayout());
      add(cardHolderPanel, BorderLayout.CENTER);
      add(southPanel, BorderLayout.SOUTH);

      swappingImgPanel.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent pcEvt) {
            if (pcEvt.getNewValue() == State.DONE) {
               cardlayout.show(cardHolderPanel, key);
               cardCombo.setEnabled(true);
            }
         }
      });

      cardCombo.addActionListener(new CardComboListener());
   }

   private JPanel createComponentFour() {
      int rows = 4;
      int cols = 4;
      int gap = 5;
      int tfColumns = 8;
      JPanel panel = new JPanel(new GridLayout(rows, cols, gap, gap));
      for (int i = 0; i < rows * cols; i++) {
         JTextField textField = new JTextField(tfColumns);
         JPanel tfPanel = new JPanel();
         tfPanel.add(textField);
         panel.add(tfPanel);
      }
      return panel;
   }

   private JLabel createComponentThree() {
      int biWidth = 200;
      BufferedImage img = new BufferedImage(biWidth, biWidth, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = img.createGraphics();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setPaint(new GradientPaint(0, 0, Color.red, 20, 20, Color.blue, true));
      g2.fillOval(0, 0, biWidth, biWidth);
      g2.dispose();
      Icon icon = new ImageIcon(img);
      JLabel label = new JLabel(icon);
      return label;
   }

   private JScrollPane createComponentTwo() {
      JTextArea textArea = new JTextArea(15, 40);
      JScrollPane scrollpane = new JScrollPane(textArea);
      scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      return scrollpane;
   }

   private JPanel createComponentOne() {
      JPanel innerPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      String[] btnTitles = {"One", "Two", "Three"};
      for (String btnTitle : btnTitles) {
         JButton btn = new JButton(btnTitle);
         innerPanel.add(btn);
      }
      JPanel panel = new JPanel(new GridBagLayout());
      panel.add(innerPanel);
      return panel;
   }

   @SuppressWarnings("hiding")
   private void registerComponent(JComponent jComp, String key) {
      cardHolderPanel.add(jComp, key);
      componentMap.put(key, jComp);
      comboModel.addElement(key);
   }

   private class CardComboListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         final String oldKey = key;
         key  = (String) cardCombo.getSelectedItem();
         cardCombo.setEnabled(false);

         final JComponent firstComp = componentMap.get(oldKey);
         final BufferedImage firstImg = extractComponentImg(firstComp);
         final JComponent secondComp = componentMap.get(key);
         final BufferedImage secondImg = extractComponentImg(secondComp);

         cardlayout.show(cardHolderPanel, SWAPPING_IMG_PANEL);
         swappingImgPanel.setFirstImg(firstImg);
         swappingImgPanel.setSecondImg(secondImg);
         swappingImgPanel.swap();

      }

      private BufferedImage extractComponentImg(final JComponent component) {
         Dimension size = component.getSize();
         BufferedImage img = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
         Graphics2D g2 = img.createGraphics();
         component.paint(g2);
         g2.dispose();
         return img;
      }
   }

   private static void createAndShowGui() {
      DimmingPanelSwaps mainPanel = new DimmingPanelSwaps();

      JFrame frame = new JFrame("Dimming Panel Swaps");
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

/**
 * A JPanel that draws two images
 * When swap is called, the first image is shown
 * Then a Timer dims the first image while it reveals
 * the second image.
 * When the elapsed time is complete, it sets its state to State.DONE.
 * @author Pete
 *
 */
@SuppressWarnings("serial")
class SwappingImgPanel extends JPanel {
   public static final String STATE = "state";
   private BufferedImage firstImg;
   private BufferedImage secondImg;
   private int deltaTime;
   private int elapsedTime;
   // state is a "bound" property, one that is listened to via PropertyChangeSupport
   private State state = State.PENDING;
   private float alpha1;
   private float alpha2;

   public SwappingImgPanel(final int deltaTime, final int elapsedTime) {
      this.deltaTime = deltaTime;
      this.elapsedTime = elapsedTime;
   }

   public void swap() {
      setState(State.STARTED);
      if (firstImg == null || secondImg == null) {
         done();
      }
      alpha1 = 1.0f;
      alpha2 = 0.0f;
      new Timer(deltaTime, new ActionListener() {
         private int counter = 0;
         private int max = elapsedTime / deltaTime;

         @Override
         public void actionPerformed(ActionEvent e) {
            if (counter >= elapsedTime / deltaTime) {
               ((Timer)e.getSource()).stop();
               done();
               return;
            }
            // set new alpha composite values
            alpha1 = ((float)max - counter) / (float) max;
            alpha2 = (float) counter / (float) max;

            // make sure alphas are within bounds
            alpha1 = Math.min(1f, alpha1);
            alpha1 = Math.max(0f, alpha1);
            alpha2 = Math.min(1f, alpha2);
            alpha2 = Math.max(0f, alpha2);

            repaint();
            counter++;
         }
      }).start();

   }


   private void done() {
      firstImg = null;
      secondImg = null;
      setState(State.DONE);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (firstImg == null || secondImg == null) {
         return;
      }
      // create a new Graphics2D object with g.create()
      // to avoid any possible side effects from changing the 
      // composite of the JVM's Graphics object
      Graphics2D g2 = (Graphics2D) g.create();
      // set the first alpha composite, and draw the image
      g2.setComposite(((AlphaComposite)g2.getComposite()).derive(alpha1));
      g2.drawImage(firstImg, 0, 0, this);
      // set the second alpha composite, and draw the image
      g2.setComposite(((AlphaComposite)g2.getComposite()).derive(alpha2));
      g2.drawImage(secondImg, 0, 0, this);
      g2.dispose(); // can get rid of this Graphics because we created it
   }

   public void setFirstImg(BufferedImage firstImg) {
      this.firstImg = firstImg;
   }

   public void setSecondImg(BufferedImage secondImg) {
      this.secondImg = secondImg;
   }

   public State getState() {
      return state;
   }

   public void setState(State state) {
      State oldValue = this.state;
      State newValue = state; 
      this.state = state;
      firePropertyChange(STATE, oldValue, newValue);
   }
}

/**
 * Modeled on SwingWorker.StateValue
 * @author Pete
 *
 */
enum State {
   PENDING, STARTED, DONE
}