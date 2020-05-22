import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class LayoutDemo extends JFrame {

    LayoutDemo() {
        super("LayoutDemo");
        super.setSize(400, 200);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createGUI();
        super.setVisible(true);
    }

    private void createGUI() {
        // set the layout of this frame
        super.setLayout(new BorderLayout());

        // create a panel to put the button on
        final JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // create a text area to put in the center
        final JTextArea textArea = new JTextArea();

        // create the search button
        final JButton searchButton = new JButton("search");

        // add a listener to the button that add some text to the text area
        searchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText() + "pressed search on " + (new Date()) + "\n");
            }
        });

        // add the button to the bottom panel
        bottomPanel.add(searchButton);

        // wrap a scroll-pane around the text area and place it on the center of this frame
        super.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // put the bottom panel (containing the button) on the 'south' of this frame
        super.add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LayoutDemo();
            }
        });
    }
}