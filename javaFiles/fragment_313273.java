import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SRTool {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                // the GUI as seen by the user (without frame)
                JPanel gui = new JPanel(new GridLayout(0,1,6,6));
                gui.setBorder(new EmptyBorder(2, 3, 2, 3));

                // show the BG
                gui.setBackground(Color.CYAN);
                // center the label text
                gui.add(new JLabel(
                        "Service Desk SR Tool", SwingConstants.CENTER));
                // create a lyout that can center multiple components
                FlowLayout layout = new FlowLayout(FlowLayout.CENTER,5,5);
                JPanel srPanel = new JPanel(layout);
                gui.add(srPanel);
                srPanel.add(new JLabel("SR:"));
                srPanel.add(new JTextField(8));

                JPanel returnTicketPanel = new JPanel(layout);
                gui.add(returnTicketPanel);
                returnTicketPanel.add(new JLabel("Returning Ticket?"));
                returnTicketPanel.add(new JCheckBox());

                JPanel reasonPanel = new JPanel(layout);
                gui.add(reasonPanel);
                reasonPanel.add(new JLabel("Reason:"));
                reasonPanel.add(new JTextField(14));

                JPanel buttonPanel = new JPanel(layout);
                gui.add(buttonPanel);
                buttonPanel.add(new JButton("Start!"));

                JFrame f = new JFrame("Demo");
                f.add(gui);
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See https://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // should be done last, to avoid flickering, moving,
                // resizing artifacts.
                f.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}