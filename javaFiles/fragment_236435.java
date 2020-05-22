package com.ggl.testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImageMove implements Runnable {

    private JFrame frame;

    private JourneyRunnable journeyRunnable;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ImageMove());
    }

    @Override
    public void run() {
        frame = new JFrame("Image Move");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });

        DrawingPanel drawingPanel = new DrawingPanel();
        frame.add(drawingPanel);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        journeyRunnable = new JourneyRunnable(drawingPanel, new Journey());
        new Thread(journeyRunnable).start();
    }

    public void exitProcedure() {
        journeyRunnable.setRunning(false);
        frame.dispose();
        System.exit(0);
    }

    public class DrawingPanel extends JPanel {

        private static final long serialVersionUID = -8498462824787395933L;

        private int xPos, yPos, width, height;

        private Leg leg;

        public DrawingPanel() {
            this.width = 100;
            this.height = 50;
            this.xPos = 0;
            this.yPos = (200 - height) / 2;
            this.setPreferredSize(new Dimension(800, 200));
        }

        public void setLeg(Leg leg) {
            this.leg = leg;
            this.xPos += 10;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(Color.ORANGE);
            g.fillRect(xPos, yPos, width, height);

            if (leg != null) {
                g.setColor(Color.BLACK);
                centerString(g, new Rectangle(xPos, yPos, width, height),
                        leg.getName(), g.getFont());
            }
        }

        /**
         * This method centers a <code>String</code> in a bounding
         * <code>Rectangle</code>.
         * 
         * @param g
         *            - The <code>Graphics</code> instance.
         * @param r
         *            - The bounding <code>Rectangle</code>.
         * @param s
         *            - The <code>String</code> to center in the bounding
         *            rectangle.
         * @param font
         *            - The display font of the <code>String</code>
         * 
         * @see java.awt.Graphics
         * @see java.awt.Rectangle
         * @see java.lang.String
         */
        public void centerString(Graphics g, Rectangle r, String s, Font font) {
            FontRenderContext frc = new FontRenderContext(null, true, true);

            Rectangle2D r2D = font.getStringBounds(s, frc);
            int rWidth = (int) Math.round(r2D.getWidth());
            int rHeight = (int) Math.round(r2D.getHeight());
            int rX = (int) Math.round(r2D.getX());
            int rY = (int) Math.round(r2D.getY());

            int a = (r.width / 2) - (rWidth / 2) - rX;
            int b = (r.height / 2) - (rHeight / 2) - rY;

            g.setFont(font);
            g.drawString(s, r.x + a, r.y + b);
        }
    }

    public class JourneyRunnable implements Runnable {

        private boolean running;

        private DrawingPanel drawingPanel;

        private Journey journey;

        public JourneyRunnable(DrawingPanel drawingPanel, Journey journey) {
            this.drawingPanel = drawingPanel;
            this.journey = journey;
            this.running = true;
        }

        @Override
        public void run() {
            while (running) {
                Leg leg = journey.getLeg();
                setLeg(leg);
                sleep(leg);
            }
        }

        public void setLeg(final Leg leg) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    drawingPanel.setLeg(leg);
                }
            });
        }

        private void sleep(Leg leg) {
            try {
                Thread.sleep(leg.getDelay());
            } catch (InterruptedException e) {

            }
        }

        public void setRunning(boolean running) {
            this.running = running;
        }

    }

    public class Journey {

        private int index;
        private List<Leg> legs;

        public Journey() {
            this.legs = new ArrayList<>();

            this.legs.add(new Leg("Name 1", 2000L));
            this.legs.add(new Leg("Name 2", 1000L));
            this.legs.add(new Leg("Name 3", 2000L));
            this.legs.add(new Leg("Name 4", 1000L));
            this.legs.add(new Leg("Name 5", 2000L));
            this.legs.add(new Leg("Name 6", 1000L));
            this.legs.add(new Leg("Name 7", 2000L));
            this.legs.add(new Leg("Name 8", 1000L));
            this.legs.add(new Leg("Name 9", 2000L));
            this.legs.add(new Leg("Name 10", 1000L));

            this.index = 0;
        }

        public Leg getLeg() {
            Leg leg = legs.get(index);
            index = ++index % legs.size();
            return leg;
        }
    }

    public class Leg {
        private final String name;
        private final long delay;

        public Leg(String name, long delay) {
            this.name = name;
            this.delay = delay;
        }

        public String getName() {
            return name;
        }

        public long getDelay() {
            return delay;
        }

    }

}