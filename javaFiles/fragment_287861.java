import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonExample {

    private JPanel panel;
    private JLabel label;

    public ButtonExample(){
        panel = new JPanel();
        label = new JLabel(" ");
        ActionListener listener = new MyActionListener();

        JButton buttonA = new JButton("Press me A");
        buttonA.setActionCommand("A");
        buttonA.addActionListener(listener);

        JButton buttonB = new JButton("Press me B");
        buttonB.setActionCommand("B");
        buttonB.addActionListener(listener);

        JButton buttonC = new JButton("Press me C");
        buttonC.setActionCommand("C");
        buttonC.addActionListener(listener);

        panel.add(buttonA);
        panel.add(buttonB);
        panel.add(buttonC);
    }

    private class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = (label.getText() == null || label.getText().isEmpty() )?"":label.getText();
            label.setText(text+e.getActionCommand());           
        }


    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Textfield example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLocationByPlatform(Boolean.TRUE);
        ButtonExample buttonExample =new ButtonExample();
        frame.add(buttonExample.panel,BorderLayout.CENTER);
        frame.add(buttonExample.label,BorderLayout.NORTH);

        //Display the window.
        frame.pack();
        frame.setVisible(Boolean.TRUE);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }


}