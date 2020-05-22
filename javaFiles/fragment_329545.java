package com.zetcode;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class MigLayoutEx extends JFrame {

    public MigLayoutEx() {

        initUI();
    }

    private void initUI() {

        JPanel pnl = new JPanel(new MigLayout("ins dialog, center, "
                + "center, wrap"));

        pnl.add(new JLabel("Text one"));
        pnl.add(new JTextField(15));
        pnl.add(new JLabel("Text two"));
        pnl.add(new JTextField(15));

        add(pnl);

        pack();

        setTitle("MigLayout example");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MigLayoutEx ex = new MigLayoutEx();
                ex.setVisible(true);
            }
        });       
    }
}