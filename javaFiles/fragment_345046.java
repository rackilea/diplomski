import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;

public class TurnListenerOnAndOff extends JPanel {
    private JLabel myLabel = new JLabel("My Label");
    private JCheckBox listenerEnabledCheckBox = new JCheckBox("Listener Enabled", true);

    public TurnListenerOnAndOff() {
        // make label bigger with a border
        Border outsideBorder = BorderFactory.createLineBorder(Color.black);
        Border insideBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        myLabel.setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));

        // create and add MyMouseListener to my label
        myLabel.addMouseListener(new MyMouseListener());

        // add components to the GUI's main JPanel
        add(myLabel);
        add(listenerEnabledCheckBox);
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            // if the JCheckBox isn't checked...
            if (!listenerEnabledCheckBox.isSelected()) {
                return;  // let's get out of here
            }

            // otherwise if the check box is checked, do following code
            System.out.println("myLabel pressed!");
        }
    }

    private static void createAndShowGui() {
        TurnListenerOnAndOff mainPanel = new TurnListenerOnAndOff();

        JFrame frame = new JFrame("On and Off");
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