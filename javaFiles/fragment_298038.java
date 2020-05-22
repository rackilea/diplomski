package com.ggl.testing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TextStatistics {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Text Statistics Tool");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                TextStatisticsPanel panel = new TextStatistics().new TextStatisticsPanel();
                frame.add(panel);

                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    public class TextStatisticsPanel extends JPanel {
        private static final long serialVersionUID = 9049744714586970558L;
        // Field for block of text
        private JTextArea userText;
        // Button to calculate Statistics
        private JButton stats;
        // Label for where statistics are shown and statistics
        private JLabel averageLength, totalWords;
        private JTextField averageLengthField, totalWordsField;

        public TextStatisticsPanel() {

            // creating the area for user text with wrapped text
            userText = new JTextArea();
            userText.setWrapStyleWord(true);
            userText.setLineWrap(true);

            // create button
            stats = new JButton("Update Text Statistics");
            stats.setAlignmentX(JButton.CENTER_ALIGNMENT);
            // Listener for button
            stats.addActionListener(new ButtonListener());

            // Tilted border creater
            JPanel statPanel = new JPanel();
            statPanel.setBorder(BorderFactory
                    .createTitledBorder("Text Statistics"));
            statPanel.setLayout(new BoxLayout(statPanel, BoxLayout.PAGE_AXIS));
            statPanel.setOpaque(false);

            // Create Scroller
            JScrollPane scroller = new JScrollPane(userText);
            scroller.setPreferredSize(new Dimension(350, 400));
            scroller.setBorder(BorderFactory
                    .createTitledBorder("Enter the text below"));

            // Add the statistics labels
            averageLength = new JLabel("The average length of the words: ");
            averageLength.setOpaque(false);

            averageLengthField = new JTextField(10);
            averageLengthField.setEditable(false);
            averageLengthField.setOpaque(false);

            totalWords = new JLabel("The total number of words: ");
            totalWords.setOpaque(false);

            totalWordsField = new JTextField(10);
            totalWordsField.setEditable(false);
            totalWordsField.setOpaque(false);

            // add GUI
            setLayout(new BorderLayout());

            statPanel.add(stats);
            statPanel.add(Box.createVerticalStrut(10));

            JPanel lengthPanel = new JPanel();
            lengthPanel.setOpaque(false);
            lengthPanel.add(averageLength);
            lengthPanel.add(averageLengthField);
            statPanel.add(lengthPanel);
            statPanel.add(Box.createVerticalStrut(10));

            JPanel wordsPanel = new JPanel();
            wordsPanel.setOpaque(false);
            wordsPanel.add(totalWords);
            wordsPanel.add(totalWordsField);
            statPanel.add(wordsPanel);

            add(statPanel, BorderLayout.SOUTH);
            add(scroller, BorderLayout.CENTER);
            setBackground(new java.awt.Color(202, 225, 255));
        }

        // When button is pressed do :
        private class ButtonListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {

                if (event.getSource() == stats) {
                    // Call statUpdate Method
                    statUpdate();
                }
            }

            // Create statUpdate Method
            private void statUpdate() {
                // Grab text user inputed
                String text = userText.getText();
                // Split the text by each space to find the number of words
                String[] words = text.split(" ");

                // Calculation for average
                float average = ((float) text.length() - words.length)
                        / words.length;
                //
                averageLengthField.setText(String.valueOf(average));
                totalWordsField.setText(String.valueOf(words.length));
            }
        }
    }

}