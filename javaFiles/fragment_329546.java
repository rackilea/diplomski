package com.zetcode;

import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.GroupLayout;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GroupLayoutEx extends JFrame {

    public GroupLayoutEx() {

        initUI();
    }

    private void initUI() {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        JLabel lbl1 = new JLabel("Text one");
        JLabel lbl2 = new JLabel("Text two");

        JTextField field1 = new JTextField(15);
        JTextField field2 = new JTextField(15);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(5, 50, Short.MAX_VALUE)
                .addGroup(gl.createParallelGroup(LEADING)
                .addComponent(lbl1)
                .addComponent(field1, DEFAULT_SIZE, DEFAULT_SIZE, 
                        PREFERRED_SIZE)
                .addComponent(lbl2)
                .addComponent(field2, DEFAULT_SIZE, DEFAULT_SIZE, 
                        PREFERRED_SIZE))
                .addGap(5, 50, Short.MAX_VALUE)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(5, 50, Short.MAX_VALUE)
                .addGroup(gl.createSequentialGroup()
                        .addComponent(lbl1)
                        .addComponent(field1, DEFAULT_SIZE, DEFAULT_SIZE,
                                PREFERRED_SIZE)
                        .addComponent(lbl2)
                        .addComponent(field2, DEFAULT_SIZE, DEFAULT_SIZE,
                                PREFERRED_SIZE))
                .addGap(5, 50, Short.MAX_VALUE)
        );

        pack();

        setTitle("GroupLayout example");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GroupLayoutEx ex = new GroupLayoutEx();
                ex.setVisible(true);
            }
        });
    }
}