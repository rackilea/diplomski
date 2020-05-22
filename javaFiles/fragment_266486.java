import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GradientPaintEg extends JPanel {
    private DrawingPanel drawingPanel = new DrawingPanel();
    private JSlider hue1Slider = new JSlider(0, 100, 0);
    private JSlider hue2Slider = new JSlider(0, 100, 0);

    public GradientPaintEg() {
        Color color = drawingPanel.getColor1();
        float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        int value = (int) (hsb[0] * 100);
        hue1Slider.setValue(value);

        color = drawingPanel.getColor2();
        hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        value = (int) (hsb[0] * 100);
        hue2Slider.setValue(value);

        hue1Slider.setMajorTickSpacing(20);
        hue1Slider.setMinorTickSpacing(5);
        hue1Slider.setPaintTicks(true);
        hue1Slider.setPaintLabels(true);
        hue1Slider.setPaintTrack(true);
        hue1Slider.addChangeListener(new SliderListener(hue1Slider, drawingPanel, true));
        hue1Slider.setOpaque(false);

        hue2Slider.setMajorTickSpacing(20);
        hue2Slider.setMinorTickSpacing(5);
        hue2Slider.setPaintTicks(true);
        hue2Slider.setPaintLabels(true);
        hue2Slider.setPaintTrack(true);
        hue2Slider.addChangeListener(new SliderListener(hue2Slider, drawingPanel, false));
        hue2Slider.setOpaque(false);

        JPanel sliderPanel = new JPanel(new GridLayout(0, 1, 4, 4));
        sliderPanel.add(hue1Slider);
        sliderPanel.add(hue2Slider);

        sliderPanel.setOpaque(false);

        setLayout(new BorderLayout());
        // if you want to add the slider panel to the main JPanel:
        // add(sliderPanel, BorderLayout.PAGE_START);
        add(drawingPanel);

        // if you want to add the sliderPanel to the drawing JPanel
        drawingPanel.setLayout(new BorderLayout());
        drawingPanel.add(sliderPanel, BorderLayout.PAGE_START);
    }

    private class SliderListener implements ChangeListener {
        private JSlider slider;
        private DrawingPanel drawingPanel;
        private boolean color1Listener;

        public SliderListener(JSlider slider, DrawingPanel drawingPanel, boolean color1Listener) {
            this.slider = slider;
            this.drawingPanel = drawingPanel;
            this.color1Listener = color1Listener;
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            int value = slider.getValue();
            float hue = value / 100f;
            Color c = Color.getHSBColor(hue, 1f, 1f);
            if (color1Listener) {
                drawingPanel.setColor1(c);
            } else {
                drawingPanel.setColor2(c);
            }
        }
    }

    private static void createAndShowGui() {
        GradientPaintEg mainPanel = new GradientPaintEg();

        JFrame frame = new JFrame("GradientPaintEg");
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

class DrawingPanel extends JPanel {
    private static final int PREF_W = 600;
    private static final int PREF_H = PREF_W;
    private static final float X2 = 20;
    private static final float Y2 = X2;
    private Color color1 = Color.RED;
    private Color color2 = Color.BLUE;

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
        repaint();
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(new GradientPaint(0, 0, color1, X2, Y2, color2, true));
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

}