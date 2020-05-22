package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PaintPanel extends JPanel implements ActionListener
{

    int x = 200, y = 250;
    private JButton b1 = new JButton("BLUE");
    private JButton b2 = new JButton("RED");
    private JButton b3 = new JButton("GREEN");
    JLabel label = new JLabel("Choose the right Color");
    JPanel subPanel = new JPanel();
    private Color[] colors;
    Color tmp = null;

    public PaintPanel()
    {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(440, 440));
        add(label, BorderLayout.NORTH);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        subPanel.add(b1);
        b1.setForeground(Color.BLUE);
        subPanel.add(b2);
        b2.setForeground(Color.RED);
        subPanel.add(b3);
        b3.setForeground(Color.GREEN);
        add(subPanel, BorderLayout.SOUTH);

    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        colors = new Color[3]; //Referencing Class member colors instead of local variable
        colors[0] = Color.BLUE;
        colors[1] = Color.RED;
        colors[2] = Color.GREEN;

        tmp = colors[randInt(colors.length)]; //Read into a class member instead of a local variable
        g.setColor(tmp);
        System.out.println("Paint Triggered. New Color is: " + tmp.toString()); //todo remove this debugging line
        g.fillOval(x, y, 30, 30);
    }

    private int randInt(int length)
    {
        // TODO Auto-generated method stub
        Random rand = new Random();
        int randomColor = rand.nextInt(length);
        return randomColor;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == b1) {
            if (Color.BLUE.equals(tmp)) {
                label.setText("You WIN");
            } else {
                label.setText("You Loose");
            }
        } else if (e.getSource() == b2) {
            if (Color.RED.equals(tmp)) {
                label.setText("You WIN");
            } else {
                label.setText("You Loose");
            }
        } else if (e.getSource() == b3) {
            if (Color.GREEN.equals(tmp)) {
                label.setText("You WIN");
            } else {
                label.setText("You Loose");
            }
        }
        updateUI(); //<---------------IMPORTANT To Sync What you see with each button press.
    }
}