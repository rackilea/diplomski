package de.steamnet.samples;

// This class is a Panel that renders buttons based on rights.

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ActionContainer extends JPanel {
    List<JButton> buttons = new ArrayList<JButton>();

    public ActionContainer(String rightBase) {
        List<String> rights = database.getRightsStartingWith(rightBase);
        for(String nextRight : rights) {
            JButton next = new JButton(nextRight);
            buttons.add(next);
            if(user.hasRight(nextRight)) {
                next.setEnabled(true);
            } else {
                next.setEnabled(false);
            }
            add(next);
        }
    }

    public void addActionListener(ActionListener al) {
        for(JButton next: buttons) {
            next.addActionListener(al);
        }
    }
}