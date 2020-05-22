import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SceneOne extends JPanel
                 implements ActionListener {

    private JLayeredPane layeredPane;
    private JLabel imageLabel;
    int frameWidth,frameHeight;
    Rectangle bounds;

    public SceneOne()    {
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

    //Set the width of the frame here. It could be changes to the image width.
    frameWidth = 1400;
    frameHeight = 700;
    bounds = new Rectangle(0, 0, frameWidth, frameHeight);

    final ImageIcon bgImage = new ImageIcon("/Users/computerscience2/Desktop/dark-forest-night-image.jpg");
    imageLabel = new JLabel(bgImage);
    if (bgImage != null) {
        imageLabel.setBounds(0, 0,
                bgImage.getIconWidth(),
                bgImage.getIconHeight());
    }

    //Create and set up the layered pane.
    layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(new Dimension(frameWidth, frameHeight));

    //The components
    JPanel buttonPanel = createButtonPanel();

    JLabel textLabel = new JLabel("Test");
    textLabel.setText("<html><font color='white'> It was approximately 11:30 pm. The night sky was black not a single star piercing through the darkness"
        + "except the thick and powerful moonlight."
        + "<br>"
        + "You are alone leaving a costume party at a friend's place."
        + "It was rather boring and you decided to leave early."
        + "A stutter is heard and your"
        + "<br>"
        + "car begins to shake"
        + "Your headlights and car lights crack. The engine is left dead silent."
        + "You are left in a total silence"
        + "and baked in merely the moonlight."
        + "<br>"
        + "There is a mere second of silence till a harsh chill ripes through the"
        + "car like a bullet through paper. You are left dumbfounded. What do you do?</font><html>");
    textLabel.setHorizontalAlignment(JLabel.CENTER);
    textLabel.setVerticalAlignment(JLabel.BOTTOM);
    textLabel.setBounds(bounds);

    //Adding components in order
    layeredPane.add(imageLabel, new Integer(0));
    layeredPane.add(buttonPanel, new Integer(1));
    layeredPane.add(textLabel, new Integer(2));

    add(layeredPane);
    }

    private JPanel createButtonPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    panel.setBounds(bounds);
    panel.setOpaque(false);
    panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

    GridBagConstraints c = new GridBagConstraints();

    JButton button;
    panel.setLayout(new GridBagLayout());
    c.fill = GridBagConstraints.NONE;

    button = new JButton("Stay");
    c.weightx = 0.5;
    c.weighty = 1.0;
    c.gridx = 0;
    c.gridy = 0;
    c.anchor = GridBagConstraints.FIRST_LINE_START;
    button.addActionListener(this);
    panel.add(button, c);

    button = new JButton("Leave");
    c.weightx = 0.5;
    c.gridx = 2;
    c.gridy = 0;
    c.anchor = GridBagConstraints.FIRST_LINE_END;
    button.addActionListener(this);
    panel.add(button, c);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

    if ("Stay".equalsIgnoreCase(cmd)) {
        JOptionPane.showMessageDialog(this, "Stay here!!!");
    } else if ("Leave".equalsIgnoreCase(cmd)) {
        JOptionPane.showMessageDialog(this, "Bye bye!!!");
    }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
    JFrame frame = new JFrame("SceneOne");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JComponent newContentPane = new SceneOne();
    frame.setLayout(null);
    frame.setContentPane(newContentPane);

    frame.pack();
    frame.setVisible(true);
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