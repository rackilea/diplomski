import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class CommonFrame extends JFrame implements MyFrameListener {

    protected JLabel myLabelForControlMove;
    private JButton btnControlMove;
    private JPanel panel;

    public CommonFrame() {
        panel = new JPanel();
        add(panel);
        myLabelForControlMove = new JLabel("waiting for information...");
        panel.add(myLabelForControlMove);
        btnControlMove = new JButton("click to control move");
        panel.add(btnControlMove);
        setVisible(true);
        pack();


        // call concrete class with no aware which one is used
        onMovementStateCreation();

        btnControlMove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            // call concrete class with no aware which one is used
            onMovementStateControl();
            }
        });
    }
}



public interface MyFrameListener {

  void onMovementStateCreation();

  void onMovementStateControl();

}


public class Gui1 extends CommonFrame {

 @Override
 public void onMovementStateCreation() {
   myLabelForControlMove.setText("control starts");
 }

 @Override
 public void onMovementStateControl() {
   myLabelForControlMove.setText("control with state Gui1");
 }

}


public class Gui2 extends CommonFrame {

  @Override
  public void onMovementStateCreation() {
    myLabelForControlMove.setText("control with state Gui2");
  }

  @Override
  public void onMovementStateControl() {
    // does nothing
  }

}