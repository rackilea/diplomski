package org.dchan.orm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class displays a window with a slider component. The user can slide the
 * left or right slider. As the sliders are adjusted it displays the maximum
 * sound level coming from either slider as well as the total.
 */

public class SoundLevels extends JFrame {
    private JLabel label1, label2, label3, label4; // Message labels
    private JTextField maxSound; // Max Sound Level
    private JTextField totalSound; // Total Sound Level
    private JPanel mpanel; // Max sound level panel
    private JPanel tpanel; // Total sound level panel
    private JPanel sliderPanel1; // Slider panel 1
    private JPanel sliderPanel2; // Slider panel 2
    private JPanel resetpanel; // Reset button panel
    private JSlider slider1; // Left sound adjuster
    private JSlider slider2; // Right sound adjuster
    private JButton resetButton; // Reset button

    /**
     * Constructor
     */

    public SoundLevels() {
        // Set the title.
        setTitle("Sound Levels");

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creates reset button
        resetButton = new JButton("Reset");

        // Create the message labels.
        label1 = new JLabel("Left:  ");
        label2 = new JLabel("Right: ");
        label3 = new JLabel("Max:   ");
        label4 = new JLabel("Total: ");

        // Create the read-only text fields.
        maxSound = new JTextField("0", 10);
        maxSound.setEditable(false);
        totalSound = new JTextField("0", 10);
        totalSound.setEditable(false);

        // Create the slider.
        slider1 = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        slider2 = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        slider1.addChangeListener(new SliderListener());
        slider2.addChangeListener(new SliderListener());
        // Create panels and place the components in them.
        mpanel = new JPanel();
        resetpanel = new JPanel();
        tpanel = new JPanel();
        sliderPanel1 = new JPanel();
        sliderPanel2 = new JPanel();

        // Add components to panels
        mpanel.add(label1);
        mpanel.add(maxSound);

        tpanel.add(label2);
        tpanel.add(totalSound);

        sliderPanel1.add(label1);
        sliderPanel1.add(slider1);

        sliderPanel2.add(label2);
        sliderPanel2.add(slider2);

        resetpanel.add(resetButton);

        // Initialize event listener
        // resetButton.addActionListener(new ResetButtonListener());

        // Sets window to a border layout format.
        setLayout(new GridLayout(1, 5));

        // Add the panels to the content pane.
        add(sliderPanel1);
        add(sliderPanel2);
        add(resetpanel);
        add(mpanel);
        add(tpanel);

        // Pack and display the frame.
        pack();
        setVisible(true);
    }

    /**
     * Private inner class that handles the event when the user clicks the Reset
     * button.
     */

    /*
     * COMMENTED THIS OUT SO IT AT LEAST RUNS
     */private class ResetButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Set the panel's background to red.
            // max = 0; // should reset sliders to 0
            // total = 0; // should reset sliders to 0
            slider1.setValue(0);
            slider2.setValue(0);
        }
    }

    /*
*/

    /**
     * Private inner class to handle the change events that are generated when
     * the slider is moved.
     */

    private class SliderListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            int max = 0;
            int total = 0;
            // Get the slider value.
            int slider1Val = slider1.getValue();
            int slider2Val = slider2.getValue();
            if (slider1Val > slider2Val) {
                max = slider1Val;
            } else {
                max = slider2Val;
            }
            total = slider2Val + slider1Val;
            // Store the total sound level in its display field.
            totalSound.setText(Integer.toString(total));

            // Store the max sound level in its display field.
            maxSound.setText(Integer.toString(max));
        }
    }

    /*
     * The main method creates an instance of the class, which displays a window
     * with a slider.
     */

    public static void main(String[] args) {
        new SoundLevels();
    }
}