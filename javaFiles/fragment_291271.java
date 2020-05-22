import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Action {

public static void main(String[] args) {

    JButton b1 = new JButton("action");
    b1.setVisible(true);
    b1.setSize(100,30);  //Cannot instantiate the type
    b1.addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent e) {
                    //Some action.

                }

            });
    }

}