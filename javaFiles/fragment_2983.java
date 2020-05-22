import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Foo extends JPanel {
   private static final long serialVersionUID = 1L;
   private Action helloAction = new HelloAction("Hello", KeyEvent.VK_H);
   private Action exitAction = new ExitAction("Exit", KeyEvent.VK_X);
   private JMenuBar menuBar = new JMenuBar();
   private JTextField sliderValueField = new JTextField(10);
   private Bar bar = new Bar();

   public Foo() {
      sliderValueField.setEditable(false);
      sliderValueField.setFocusable(false);

      add(new JButton(helloAction));
      add(new JButton(exitAction));
      add(new JLabel("Slider Value: "));
      add(sliderValueField);
      add(bar);

      JMenu fileMenu = new JMenu("File");
      fileMenu.setMnemonic(KeyEvent.VK_F);
      fileMenu.add(new JMenuItem(exitAction));
      fileMenu.add(new JMenuItem(helloAction));
      menuBar.add(fileMenu);

      bar.addSliderListener(new ChangeListener() {

         @Override
         public void stateChanged(ChangeEvent e) {
            int sliderValue = bar.getSliderValue();
            sliderValueField.setText(String.valueOf(sliderValue));
         }
      });
   }

   public JMenuBar getJMenuBar() {
      return menuBar;
   }

   private static void createAndShowGui() {
      Foo mainPanel = new Foo();

      JFrame frame = new JFrame("Foo");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.setJMenuBar(mainPanel.getJMenuBar());
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

class HelloAction extends AbstractAction {

   public HelloAction(String name, int mnemonic) {
      super(name); // sets name property and gives button its title
      putValue(MNEMONIC_KEY, mnemonic);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      JOptionPane.showMessageDialog(null, "Hello!");
   }
}

class ExitAction extends AbstractAction {
   private static final long serialVersionUID = 1L;

   public ExitAction(String name, int mnemonic) {
      super(name);
      putValue(MNEMONIC_KEY, mnemonic);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Component component = (Component) e.getSource();
      Window win = SwingUtilities.getWindowAncestor(component);
      if (win == null) {
         // if no window, then a JMenuItem held in a JPopupMenu
         JPopupMenu popup = (JPopupMenu) component.getParent();
         component = popup.getInvoker();
         win = SwingUtilities.getWindowAncestor(component);
      }
      win.dispose();
   }
}

class Bar extends JPanel {
   private JSlider slider = new JSlider(0, 100, 50);

   public Bar() {
      slider.setPaintLabels(true);
      slider.setPaintTicks(true);
      slider.setMajorTickSpacing(20);
      slider.setMinorTickSpacing(5);
      slider.setSnapToTicks(true);
      setBorder(BorderFactory.createTitledBorder("Slider Panel"));
      add(slider);
   }

   public int getSliderValue() {
      return slider.getValue();
   }

   // one way to let outside classes listen for changes
   public void addSliderListener(ChangeListener listener) {
      slider.addChangeListener(listener);
   }
}