import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SimpleMCV {

   private static void createAndShowGui() {
      final SimpleView simpleView = new SimpleView();
      final SimpleModel simpleModel = new SimpleModel("");
      MainControl mainControl = new MainControl();
      mainControl.setUp(simpleView, simpleModel);

      JFrame frame = new JFrame("Simple GUI");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(simpleView);
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

@SuppressWarnings("serial")
class SimpleView extends JPanel {
   private JTextField textField = new JTextField(10);

   public SimpleView() {
      textField.setFocusable(false);
      add(textField);
   }

   public void setTextFieldText(String text) {
      textField.setText(text);
   }

   public void addAction(Action action) {
      add(new JButton(action));
   }
}

class MainControl {
   public void setUp(final SimpleView simpleView, final SimpleModel simpleModel) {
      simpleView.addAction(new SimpleControl(simpleModel, "Fubar"));
      simpleView.addAction(new SimpleControl(simpleModel, "Snafu"));
      simpleView.addAction(new SimpleControl(simpleModel, "Bohica"));

      simpleModel.addChangeListener(new ChangeListener() {

         @Override
         public void stateChanged(ChangeEvent e) {
            simpleView.setTextFieldText(simpleModel.getSomeText());
         }
      });
   }
}

@SuppressWarnings("serial")
class SimpleControl extends AbstractAction {
   private SimpleModel simpleModel;

   public SimpleControl(SimpleModel simpleModel, String name) {
      super(name);
      int mnemonic = (int) name.charAt(0);
      putValue(MNEMONIC_KEY, mnemonic);
      this.simpleModel = simpleModel;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      simpleModel.setSomeText(e.getActionCommand());
   }

}

class SimpleModel {
   private List<ChangeListener> listenerList = new ArrayList<>();
   private String someText;

   public SimpleModel(String someText) {
      this.someText = someText;
   }

   public String getSomeText() {
      return someText;
   }

   // change text and notify all listeners
   public void setSomeText(String someText) {
      this.someText = someText;
      for (ChangeListener changeListener : listenerList) {
         changeListener.stateChanged(new ChangeEvent(this));
      }
   }

   // allow outside classes to add a ChangeListener
   public void addChangeListener(ChangeListener cl) {
      listenerList.add(cl);
   }
}