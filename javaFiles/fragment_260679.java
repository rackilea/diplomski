package com.ggl.crossword.controller;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.ggl.crossword.view.CrosswordFrame;

public class CreateImageActionListener implements ActionListener {

    private CrosswordFrame frame;

    private JPanel panel;

    public CreateImageActionListener(CrosswordFrame frame,
            JPanel panel) {
        this.frame = frame;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        writeImage();
    }

    public void writeImage() {
        FileFilter filter = 
                new FileNameExtensionFilter("PNG file", "png");
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(filter);
        int returnValue = fc.showSaveDialog(frame.getFrame());
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (!file.getAbsolutePath().endsWith(".png")) {
                file = new File(file.getAbsolutePath() + ".png");
            }
            RenderedImage image = createImage(panel);
            try {
                ImageIO.write(image, "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private BufferedImage createImage(JPanel panel) {
        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, 
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);
        g.dispose();
        return bi;
    }

}