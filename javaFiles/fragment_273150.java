import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class CrossRoads2 extends JPanel {
    private static final int PREF_W = 400;
    private static final int PREF_H = PREF_W;
    private static final int TIMER_DELAY = 100;
    List<TrafficLight2> lights = new ArrayList<>();

    public CrossRoads2() {
        // create a timer to randomly change traffic light state
        // and start it
        new Timer(TIMER_DELAY, new TimerListener()).start();

        // create 4 TrafficLight2 objects and place them at 4
        // compass locations, and add to lights ArrayList
        int x = (PREF_W - TrafficLight2.getWidth()) / 2;
        int y = 0;
        lights.add(new TrafficLight2(x, y));
        x = 0;
        y = (PREF_H - TrafficLight2.getHeight()) / 2;
        lights.add(new TrafficLight2(x, y));
        x = (PREF_W - TrafficLight2.getWidth());
        lights.add(new TrafficLight2(x, y));
        x = (PREF_W - TrafficLight2.getWidth()) / 2;
        y = (PREF_H - TrafficLight2.getHeight());
        lights.add(new TrafficLight2(x, y));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // cast g into a Graphics2 object
        Graphics2D g2 = (Graphics2D) g;

        // for smooth rendering
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // iterate through the ArrayList, calling the draw method on each light 
        for (TrafficLight2 light : lights) {
            light.draw(g2);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        // give our JPanel a decent size
        return new Dimension(PREF_W, PREF_H);
    }

    // ActionListener that randomly changes the LightState of each traffic light
    private class TimerListener implements ActionListener {
        private Random random = new Random();

        @Override
        public void actionPerformed(ActionEvent e) {
            for (TrafficLight2 light : lights) {
                // random number 0 to 2
                int randomIndex = random.nextInt(LightState.values().length);

                // get one of the LightStates using the index above
                LightState lightState = LightState.values()[randomIndex];
                // set our light to this state
                light.setLightState(lightState);
            }
            repaint();
        }
    }

    private static void createAndShowGui() {
        CrossRoads2 mainPanel = new CrossRoads2();

        JFrame frame = new JFrame("Cross Roads");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}