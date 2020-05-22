package org.pscode.eg.docload;

import java.awt.FlowLayout;
import javax.swing.*;

public class Example extends JApplet {


    JLabel label;

    public void init()
    {
        System.out.println("init()");
        SwingUtilities.invokeLater(new Runnable(){public void run() {
            label = new JLabel("inited.");
            getContentPane().setLayout(new FlowLayout());
            getContentPane().add(label);
        }});
    }

    @Override
    public void start() {
        System.out.println("start()");
        label.setText("started.");
    }

    @Override
    public void stop() {
        System.out.println("stop()");
        label.setText("stopped.");
    }

    @Override
    public void destroy() {
        System.out.println("destroy()");
        label.setText("destroyed.");
    }
}