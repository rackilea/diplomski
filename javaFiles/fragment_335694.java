package com.jd.swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JFrameExample {`enter code here`
private JFrame frame;

private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 1057, 484);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    JTextArea MainTextArea = new JTextArea();
    MainTextArea.setLineWrap(true);
    MainTextArea.setWrapStyleWord(true);
    MainTextArea.setBounds(21, 93, 995, 336);
    JScrollPane scroll = new JScrollPane(MainTextArea);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setBounds(21, 93, 995, 336);
    frame.getContentPane().add(scroll);
    frame.setVisible(true);
}

public static void main(String[] args) {
    new JFrameExample().initialize();
}
}