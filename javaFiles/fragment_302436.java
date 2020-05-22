import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class clientsocket {

    public JTextArea chatbox;
    JPanel ui;

    public clientsocket() {
        ui = new JPanel(new BorderLayout(3, 3));
        // pad around the GUI
        ui.setBorder(new EmptyBorder(30, 20, 30, 20));

        // suggest a size in rows x cols
        chatbox = new JTextArea(12, 36);
        //chatbox.setBounds(20, 36, 404, 187); // set a border/cols instead
        ui.add(new JScrollPane(chatbox)); // default is CENTER
        getContentPane().add(ui);
    }

    public JComponent getUi() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            public void run() {
                clientsocket cs = new clientsocket();
                JFrame f = new JFrame("Chat Client");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                f.add(cs.getUi());

                f.pack(); // sets the GUI the smallest it can be to display the content
                f.setMinimumSize(f.getSize()); // enforce a mimimum size
                // See http://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);
                f.setVisible(true); // Should be last.
            }
        };
        SwingUtilities.invokeLater(r);
    }
}