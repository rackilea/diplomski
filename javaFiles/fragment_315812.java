import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class GraphicsEg extends JPanel {
    private static final int DATA_COLUMNS = 5;
    private List<JSlider> sliders = new ArrayList<>();
    private DrawPanel drawPanel = new DrawPanel(DATA_COLUMNS);

    public GraphicsEg() {
        JPanel sliderPanel = new JPanel(new GridLayout(1, 0, 5, 5));
        SliderListener sliderListener = new SliderListener();

        for (int i = 0; i < DATA_COLUMNS; i++) {
            JSlider slider = new JSlider(0, 100, 50);
            slider.setPaintLabels(true);
            slider.setPaintTicks(true);
            slider.setPaintTrack(true);
            slider.setMajorTickSpacing(20);
            slider.setMinorTickSpacing(5);
            slider.setOrientation(SwingConstants.VERTICAL);
            slider.addChangeListener(sliderListener);
            sliders.add(slider);
            sliderPanel.add(slider);
        }

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(5, 5));
        add(drawPanel, BorderLayout.CENTER);
        add(sliderPanel, BorderLayout.PAGE_END);

        sliderValuesIntoDrawPanel();
    }

    private void sliderValuesIntoDrawPanel() {
        int[] data = new int[DATA_COLUMNS];
        for (int i = 0; i < data.length; i++) {
            data[i] = sliders.get(i).getValue();
        }
        drawPanel.setData(data);
    }

    private class SliderListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            sliderValuesIntoDrawPanel();
        }
    }

    private static void createAndShowGui() {
        GraphicsEg mainPanel = new GraphicsEg();

        JFrame frame = new JFrame("GraphicsEg");
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

@SuppressWarnings("serial")
class DrawPanel extends JPanel {
    private static final int PREF_W = 600;
    private static final int PREF_H = 400;
    private static final int PAD = 20;
    private static final Color BORDER_COLOR = Color.BLUE;
    private static final Color COLUMN_COLOR = Color.RED;
    private static final double RELATIVE_COL_WIDTH = 2.0 / 3.0;
    private int dataColumns = 0;
    private int[] data;

    public DrawPanel(int dataColumns) {
        this.dataColumns = dataColumns;
        data = new int[dataColumns];
        setBorder(BorderFactory.createLineBorder(BORDER_COLOR));
    }

    public void setData(int[] data) {
        this.data = data;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < data.length; i++) {
            drawColumn(g, i, data[i]);
        }
    }

    private void drawColumn(Graphics g, int index, int columnHeight) {
        g.setColor(COLUMN_COLOR);
        int width = (int) (RELATIVE_COL_WIDTH * (PREF_W - 2 * PAD) / dataColumns); 
        int x = PAD + (index * (PREF_W - 2 * PAD)) / dataColumns;
        int height = (columnHeight * (PREF_H - 2 * PAD)) / 100;
        int y = PREF_H - PAD - height;
        g.fillRect(x, y, width, height);
    }
}