package javaapplication31;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Color;

import java.awt.Dimension;


public class JavaApplication31
{
    public static void main(String[] args)
    {
        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                //let's make all TabbedPanes transparent by default
                UIManager.put("TabbedPane.contentOpaque", false);

                JFrame frame = new JFrame();

                JPanel parentPanel = new JPanel();
                parentPanel.setBackground(Color.WHITE);
                frame.add(parentPanel);

                JTabbedPane tp = new JTabbedPane();               
                parentPanel.add(tp);

                //Make transparent panel
                JPanel panelTransparent = new JPanel();
                panelTransparent.setOpaque(false); // this makes panel transparent
                panelTransparent.setPreferredSize(new Dimension(200, 200));
                tp.addTab("Transparent", panelTransparent);

                //Make panel (by default panel is opaque)
                JPanel panelOpaque = new JPanel();
                tp.addTab("Opaque", panelOpaque);

                frame.setPreferredSize(new Dimension(300, 300));
                frame.pack();
                frame.setVisible(true);
            }
        };
        EventQueue.invokeLater(r);
    }
}