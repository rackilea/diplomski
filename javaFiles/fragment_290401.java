package com.ggl.guessing.game.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.ggl.guessing.game.model.GuessingGameModel;

public class GuessingGamePanel extends JPanel {

    private static final long   serialVersionUID    = 
            -2429103448910749064L;

    private boolean guessed;

    private Dimension guessesPanelDimension;

    private GameImages gameImages;

    private GuessesPanel guessesPanel;

    private GuessingGameFrame frame;

    private GuessingGameModel model;

    public GuessingGamePanel(GuessingGameFrame frame,
            GuessingGameModel model, GameImages gameImages, 
            Dimension guessesPanelDimension) {
        this.frame = frame;
        this.model = model;
        this.gameImages = gameImages;
        this.guessesPanelDimension = guessesPanelDimension;
        this.guessed = false;

        createPartControl();
    }

    private void createPartControl() {
        this.setLayout(null);
        this.setPreferredSize(gameImages.getPreferredSize());

        guessesPanel = new GuessesPanel(frame, model);
        Dimension gp = guessesPanelDimension;
        Dimension tp = gameImages.getPreferredSize();
        int x = (tp.width - gp.width) / 2;
        int y = (tp.height - gp.height) / 2;
        guessesPanel.getPanel().setBounds(x, y, gp.width, gp.height);
        this.add(guessesPanel.getPanel());
    }

    public void setGuessed(boolean guessed) {
        this.guessed = guessed;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(gameImages.getBackgroundImage(), 0, 0, null);
        if (guessed) {
            g.drawImage(gameImages.getVictoryImage(), 0, 0, null);
        }
    }
}