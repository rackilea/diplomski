package com.stackoverflow.swing.paintpipeline;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;


public class JLabelSetBorderPaintProblem extends JLabel {

    public JLabelSetBorderPaintProblem(String text) {
        super(text);
    }

    /*
     * @see javax.swing.JComponent paint(java.awt.Graphics)
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // You can not call setBorder here.

        // Please check javadoc.
    }

    /*
     * @see javax.swing.JComponent paintBorder(java.awt.Graphics)
     */
    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);
        // Here is where the Swing painting pipeline draws the current border
        // for the JLabel instance.

        // Please check javadoc.
    }

    // Start me here!
    public static void main(String[] args) {
        // SetBorder will dispatch an event to Event Dispatcher Thread to draw the
        // new border around the component - you must call setBorder inside EDT.
        // Swing rule 1.
        SwingUtilities.invokeLater(new Runnable() {

            @Override public void run() {
                // Inside EDT
                JFrame frame = new JFrame("JLabel setBorder example");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // Add the JLabel
                final JLabelSetBorderPaintProblem label = new JLabelSetBorderPaintProblem("Just press or wait...");
                frame.add(label);

                // And change the border...
                label.addMouseListener(new MouseAdapter() {
                    @Override public void mousePressed(MouseEvent e) {
                        label.setBorder(BORDERS.get(new Random().nextInt(BORDERS.size())));
                    }
                });

                // ...whenever you want
                new Timer(5000, new ActionListener() {
                    @Override public void actionPerformed(ActionEvent e) {
                        label.setBorder(BORDERS.get(new Random().nextInt(BORDERS.size())));
                    }
                }).start();

                frame.pack();
                frame.setVisible(true);
            }
        });

    }

    public static final List<Border> BORDERS;
    static {
        BORDERS = new ArrayList<Border>();
        BORDERS.add(BorderFactory.createLineBorder(Color.BLACK));
        BORDERS.add(BorderFactory.createLineBorder(Color.RED));
        BORDERS.add(BorderFactory.createEtchedBorder());
        BORDERS.add(BorderFactory.createTitledBorder("A border"));
    }
}