package com.ggl.testing;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SortFrames implements Runnable {
    private List<DataModel> dataModels;

    private JPanel[] panels;

    private JLabel[] labels;

    private Random random = new Random();

    public SortFrames() {
        this.dataModels = new ArrayList<>();
        this.random = new Random();

        for (int i = 0; i < 4; i++) {
            int number = random.nextInt(13);
            int colorNumber = random.nextInt(2);
            Color backgroundColor = Color.BLACK;
            Color foregroundColor = Color.WHITE;
            if (colorNumber == 1) {
                backgroundColor = Color.WHITE;
                foregroundColor = Color.BLACK;
            }
            dataModels.add(new DataModel(number, colorNumber, backgroundColor,
                    foregroundColor));
        }

        Collections.sort(dataModels, new DataModelComparator());
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Sort Frames");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();

        panels = new JPanel[dataModels.size()];
        labels = new JLabel[dataModels.size()];

        for (int i = 0; i < dataModels.size(); i++) {
            DataModel dataModel = dataModels.get(i);
            panels[i] = new JPanel();
            panels[i].setBackground(dataModel.getBackgroundColor());

            labels[i] = new JLabel(getDisplayText(dataModel));
            labels[i].setBackground(dataModel.getBackgroundColor());
            labels[i].setForeground(dataModel.getForegroundColor());

            panels[i].add(labels[i]);
            mainPanel.add(panels[i]);
        }

        frame.add(mainPanel);

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    private String getDisplayText(DataModel dataModel) {
        if (dataModel.getNumber() == 12) {
            return "-";
        } else {
            return Integer.toString(dataModel.getNumber());
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new SortFrames());
    }

    public class DataModel {
        private final int number;
        private final int colorNumber;

        private final Color backgroundColor;
        private final Color foregroundColor;

        public DataModel(int number, int colorNumber, Color backgroundColor,
                Color foregroundColor) {
            this.number = number;
            this.colorNumber = colorNumber;
            this.backgroundColor = backgroundColor;
            this.foregroundColor = foregroundColor;
        }

        public int getNumber() {
            return number;
        }

        public int getColorNumber() {
            return colorNumber;
        }

        public Color getBackgroundColor() {
            return backgroundColor;
        }

        public Color getForegroundColor() {
            return foregroundColor;
        }

    }

    public class DataModelComparator implements Comparator<DataModel> {

        @Override
        public int compare(DataModel o1, DataModel o2) {
            if (o1.getNumber() < o2.getNumber()) {
                return -1;
            } else if (o1.getNumber() > o2.getNumber()) {
                return 1;
            } else {
                if (o1.getColorNumber() < o2.getColorNumber()) {
                    return -1;
                } else if (o1.getColorNumber() > o2.getColorNumber()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

    }
}