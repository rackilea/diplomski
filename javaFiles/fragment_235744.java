package com.detter.john;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

public final class ComboBoxExample extends JFrame implements ActionListener
{
    public ComboBoxExample()
    {
        super("Combo Box Example");
        setLayout(null);
        panel = new JPanel();

        box = new JComboBox(options);
        box.addActionListener(this);

        panel.add(box);
        panel.setSize(100,100);
        panel.setLocation(0,0);
        panel.setVisible(true);

        imagePanel = new ImagePanel();
        add(panel);
        add(imagePanel);

        setSize(WIDTH,HEIGHT);
        setLocation(X,Y);
        setResizable(false);
        setVisible(true);
    }

    public class ImagePanel extends JPanel
    {
        public ImagePanel()
        {
            try
            {
                showing = true;
                image = ImageIO.read(new File("..\\Combobox action listener to show" +
                    " and hide an image\\Images\\SampleImage.PNG"));
            }catch(Exception e){e.printStackTrace();}

            setSize(WIDTH,HEIGHT);
            setLocation(X,Y);
            setVisible(true);
        }

        public void showImage()
        {
            showing = true;
            repaint();
        }

        public void hideImage()
        {
            showing = false;
            repaint();
        }

        public void paint(Graphics g)
        {
            Graphics2D g2 = (Graphics2D)g;
            g2.clearRect(0,0,WIDTH,HEIGHT);
            if(showing)
                g2.drawImage(image,0,0,null);
        }

        private boolean showing;
        private BufferedImage image;

        private static final int WIDTH = 100;
        private static final int HEIGHT = 100;
        private static final int X = 100;
        private static final int Y = 0;
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==box)
        {
            switch(box.getSelectedIndex())
            {
                case SHOW:
                    imagePanel.showImage();
                break;
                case HIDE:
                imagePanel.hideImage();
                break;
            }
        }
   }

    private JPanel panel;
    private ImagePanel imagePanel;
    private JComboBox box;
    private String options[] = {"show","hide"};

    private static final int SHOW = 0;
    private static final int HIDE = 1;

    private static final int X = 0;
    private static final int Y = 0;
    private static final int WIDTH = 206;
    private static final int HEIGHT = 132;

    public static void main(String args[]){new ComboBoxExample();}
}