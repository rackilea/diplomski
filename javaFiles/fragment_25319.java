package com.zetcode;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class ButtonsEx extends JFrame {

    public ButtonsEx() {

        initUI();

        setTitle("MigLayout example");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }

    private void initUI() {

        JPanel pnl = new JPanel(new MigLayout());
        pnl.add(new JButton("Button"), "spany 2, grow, w 4cm, h 4cm");
        pnl.add(new JButton("Button"), "spanx 2, w 4cm, h 2cm, grow");
        pnl.add(new JButton("Button"), "w 2cm, h 2cm, wrap");
        pnl.add(new JButton("Button"), "w 2cm, h 2cm");
        pnl.add(new JButton("Button"), "w 2cm, h 2cm");
        pnl.add(new JButton("Button"), "w 2cm, h 2cm, wrap");

        add(pnl);

        pack();
    }    

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ButtonsEx ex = new ButtonsEx();
                ex.setVisible(true);
            }
        });
    }
}