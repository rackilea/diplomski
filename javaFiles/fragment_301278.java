package Unit2Exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Unit2Exam {

    static int r;
    static int g;
    static int b;
    static int rb;
    static int rg;
    static int on;
    static int rr;
    static int i;
    public static JTextField field1;
    public static JTextField field2;
    public static JTextField field3;

    public static void main(String[] args) {

        //Makes a font
        Font font = new Font("Verdana", Font.PLAIN,  12);

        GridBagConstraints grid = new GridBagConstraints();
        //This creates the JFRAMES
        JFrame frame = new JFrame("Free Fall Application");
        //This sets the title
        JPanel panel = new JPanel(new GridBagLayout());
        //makes and adds the panel
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grid.fill = GridBagConstraints.BOTH;

        JFrame colors = new JFrame("Colors");
        JPanel colorPanel = new JPanel(new GridBagLayout());
        colors.add(colorPanel);
        colors.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grid.fill = GridBagConstraints.BOTH;

        //causes the jbuttons to fill the borders (to make it look better)
        grid.weightx = 1;
        grid.weighty = 1;
        // frame.setSize(new Dimension(200, 200));
        frame.setResizable(false);
        colors.setResizable(false);
        colors.setVisible(true);
        colorPanel.setVisible(true);
        frame.setVisible(true);
        panel.setVisible(true);

        //This is where I implement all of the J stuff (i.e. Buttons, Textfields, and JLabels)
        JLabel title = new JLabel("Jonathan Kipper");
        JLabel label1 = new JLabel("Initial Velocity (m/s):");
        JLabel label2 = new JLabel("Time (Seconds):");
        JLabel label3 = new JLabel("Distance (meters):");
        field1 = new JTextField(6);
       field2 = new JTextField(6);
         field3 = new JTextField(6);
        JButton button1 = new JButton("Calculate");
        JButton button2 = new JButton("Clear");
        JButton colorButton = new JButton();

        grid.gridx = 0;
        grid.gridy = 0;
        panel.add(title, grid);
        title.setVisible(true);
        title.setFont(font);

        grid.gridx = 0;
        grid.gridy = 1;
        panel.add(label1, grid);
        label1.setVisible(true);
        label1.setFont(font);

        grid.gridx = 0;
        grid.gridy = 2;
        panel.add(label2, grid);
        label2.setVisible(true);
        label2.setFont(font);

        grid.gridx = 0;
        grid.gridy = 3;
        panel.add(label3, grid);
        label3.setVisible(true);
        label3.setFont(font);

        grid.gridx = 1;
        grid.gridy = 1;
        panel.add(field1, grid);
        field1.setVisible(true);

        grid.gridx = 1;
        grid.gridy = 2;
        panel.add(field2, grid);
        field2.setVisible(true);

        grid.gridx = 1;
        grid.gridy = 3;
        panel.add(field3, grid);
        field3.setText("");
        field3.setVisible(true);

        grid.gridx = 0;
        grid.gridy = 4;
        panel.add(button1, grid);
        button1.setVisible(true);

        grid.gridx = 1;
        grid.gridy = 4;
        panel.add(button2, grid);
        button2.setVisible(true);
        button2.setFont(font);

        frame.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setSize(250, 150);

        grid.gridx=0;
        grid.gridy=0;
        colorPanel.add(colorButton, grid);
        colorButton.setText("Click to stop colors");
        colorButton.setVisible(true);

        colors.pack();
        Dimension dimz = Toolkit.getDefaultToolkit().getScreenSize();
        colors.setLocation(dimz.width / 3 - frame.getSize().width / 3, dimz.height / 2 - frame.getSize().height / 2);
        colors.setSize(200, 150);

        i=1;
        //Infinite for loop

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double zzz = Unit2Exam.distance();
                String za = String.valueOf(zzz);
                field3.setText(za);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                field1.setText("");
                field2.setText("");
                field3.setText("");

            }
        });



        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (i == 1) {
                    colorButton.setText("Click here to start");
                    i = 0;
                } else if (i == 0) {
                    colorButton.setText("Click here to stop");
                    i = 1;
                }

            }
        });

        on = 0;
        r = 0;
        g = 0;
        b = 0;

        rr = 255;
        rg = 255;
        rb = 255;
        //This is the loop for the color changing
        while (i != 0) {
            //Colors
            Color color = new Color(r, g, b);
            Color rcolor = new Color(rr, rg, rb);

            //Panels
            panel.setBackground(color);
            frame.setBackground(color);

            //Buttons
            button1.setBackground(rcolor);
            button2.setBackground(rcolor);
            colorButton.setBackground(rcolor);

            //Labels
            label1.setForeground(rcolor);
            label2.setForeground(rcolor);
            label3.setForeground(rcolor);
            title.setForeground(rcolor);

            //Text fields
            field1.setForeground(rcolor);
            field2.setForeground(rcolor);
            field3.setForeground(rcolor);
            field1.setBackground(color);
            field2.setBackground(color);
            field3.setBackground(color);

            //Sets a slight delay to avoid seizures
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Goes through the different colors
            if (on == 0) {
                if (r == 255) {
                    on = 1;
                } else {
                    r++;
                    rr--;
                }
            } else if (on == 1) {
                if (g == 255) {
                    on = 2;
                } else {
                    g++;
                    rg--;
                }
            } else if (on == 2) {
                if (b == 255) {
                    on = 3;
                } else {
                    b++;
                    rb--;
                }
            } else if (on == 3) {
                if (r == 0) {
                    on = 4;
                } else {
                    r--;
                    rr++;
                }
            } else if (on == 4) {
                if (g == 0) {
                    on = 5;
                } else {
                    g--;
                    rg++;
                }
            } else if (on == 5) {
                if (b == 0) {
                    on = 0;
                } else {
                    b--;
                    rb++;
                }
            }
        }
    }

    public static double distance(){

        String d = field1.getText();
        double velocity = Double.parseDouble(d);
        String dd = field2.getText();
        double time = Double.valueOf(dd);

        double totalDistance = (velocity * time) + (4.9 * (time * time));

        return totalDistance;
    }