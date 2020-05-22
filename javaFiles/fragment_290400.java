package com.ggl.guessing.game.view;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameImages {

    private Image backgroundImage;
    private Image victoryImage;

    public GameImages() {
        readBackgroundImage();
        readVictoryImage();
    }

    private void readBackgroundImage() {
        Image image = null;
        try {
            URL url = getClass().getResource("/v8k3reduced.jpg");
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.backgroundImage = image;
    }

    private void readVictoryImage() {
        Image image = null;
        try {
            URL url = getClass().getResource("/r7f8reduced.jpg");
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.victoryImage = image;
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public Dimension getPreferredSize() {
        return new Dimension(backgroundImage.getWidth(null),
                backgroundImage.getHeight(null));
    }

    public Image getVictoryImage() {
        return victoryImage;
    }

}