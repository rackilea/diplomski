package org.pscode.ui.widget;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

/** Provides a button for popping a color chooser.
The Color can be obtained by calling ColorButton.getBackground().
@author Andrew Thompson. */
public class ColorButton extends JButton implements ActionListener {

    private JColorChooser chooseColor;
    private String htmlColor;

    private String text;

    public ColorButton(String label) {
        super(label);
        text = label;
        chooseColor = new JColorChooser();
        addActionListener( this );
    }

    @Override
    public void setText(String text) {
        super.setText(
            "<html><body style='text-align: left;'><center>" +
            "<p>" +
            text +
            "<br>" +
            "<span style='width: 5px; height: 5px; " +
            "border: solid 1px black; background-color: " +
            htmlColor +
            "; color: " +
            htmlColor +
            ";'>AA</span>  " +
            "</center></body></html>");
        this.text = text;
    }

    public void actionPerformed(ActionEvent ae) {
        Color c = chooseColor.showDialog(
            this,
            "Choose Color",
            getBackground() );
        if (c!=null) {
            setBackground(c);
        }
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground( new Color(bg.getRed(), bg.getGreen(), bg.getBlue()) );
        int r = bg.getRed();
        int g = bg.getGreen();
        int b = bg.getBlue();

        htmlColor = "rgb(" + r + "," + g + "," + b + ")";
        setText(text);
    }
}