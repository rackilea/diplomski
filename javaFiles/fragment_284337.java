package test2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrafficLight3 {

    private JPanel redPanel;
    private JPanel yellowPanel;
    private JPanel greenPanel;

    // Constructor
    public TrafficLight3() {        
        redPanel = new StopLightPanel(100, Color.RED);
        yellowPanel = new StopLightPanel(100, Color.YELLOW);
        greenPanel = new StopLightPanel(100, Color.GREEN);
    }

    private static class StopLightPanel extends JPanel {
        private int diameter;
        private Color color;

        public StopLightPanel(int d, Color c) {
            diameter = d;
            color = c;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            g.fillOval(50, 25, diameter, diameter);
        }

        @Override
        public Dimension getPreferredSize(){
            int x = diameter*2;
            return new Dimension(x,x);
        }
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("Traffic Light");
        frame.setSize(200,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(3,1));
        frame.setLocationByPlatform(Boolean.TRUE);
        TrafficLight3 example = new TrafficLight3();
        frame.add(example.redPanel);
        frame.add(example.yellowPanel);
        frame.add(example.greenPanel);
        // Display the window.      
        frame.setVisible(Boolean.TRUE);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}