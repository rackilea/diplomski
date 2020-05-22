import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TaskEx extends JPanel {
    private int taskLeft = 10;

    public void doTask() {
        // 
    }

    private class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (taskLeft > 0) {
                doTask();
                taskLeft--;
            }
        }
    }
}