package com.ggl.sudoku.solver.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SolutionDialog {

    protected static final Insets   buttonInsets    = new Insets(10, 10, 0, 10);

    private int                     singleCount;
    private int                     guessCount;

    private long                    elapsedTime;

    private JDialog                 dialog;

    private SudokuFrame             frame;

    public SolutionDialog(SudokuFrame frame, int singleCount, int guessCount,
            long elapsedTime) {
        this.frame = frame;
        this.singleCount = singleCount;
        this.guessCount = guessCount;
        this.elapsedTime = elapsedTime;
        createPartControl();
    }

    private void createPartControl() {
        dialog = new JDialog(frame.getFrame(), "Statistics");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel resultsPanel = new JPanel();
        resultsPanel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel singleCountLabel = new JLabel("Cells with one possible number:");
        addComponent(resultsPanel, singleCountLabel, 0, gridy, 1, 1,
                buttonInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        String s = singleCount + " cells";
        JLabel singleCountString = new JLabel(s);
        addComponent(resultsPanel, singleCountString, 1, gridy++, 1, 1,
                buttonInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JLabel guessCountLabel = new JLabel("Cells where the solver guessed:");
        addComponent(resultsPanel, guessCountLabel, 0, gridy, 1, 1,
                buttonInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        s = guessCount + " cells";
        JLabel guessCountString = new JLabel(s);
        addComponent(resultsPanel, guessCountString, 1, gridy++, 1, 1,
                buttonInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JLabel elapsedTimeLabel = new JLabel("Elapsed Time:");
        addComponent(resultsPanel, elapsedTimeLabel, 0, gridy, 1, 1,
                buttonInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        s = elapsedTime + " milliseconds";
        JLabel elapsedTimeString = new JLabel(s);
        addComponent(resultsPanel, elapsedTimeString, 1, gridy++, 1, 1,
                buttonInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        mainPanel.add(resultsPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton okButton = new JButton("OK");
        okButton.setAlignmentX(JButton.RIGHT_ALIGNMENT);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        });
        buttonPanel.add(okButton);

        mainPanel.add(buttonPanel);

        dialog.add(mainPanel);
        dialog.pack();
        dialog.setBounds(getBounds());
        dialog.setVisible(true);
    }

    private void addComponent(Container container, Component component,
            int gridx, int gridy, int gridwidth, int gridheight, Insets insets,
            int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 1.0D, 1.0D, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

    protected Rectangle getBounds() {
        Rectangle f = frame.getBounds();
        Rectangle d = dialog.getBounds();
        d.x = f.x + (f.width - d.width) / 2;
        d.y = f.y + (f.height - d.height) / 2;
        return d;
    }

}