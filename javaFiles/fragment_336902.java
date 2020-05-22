package testSwing;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.UIManager;


public class Main{
    public static void main(String[] args){
        try{                UIManager.setLookAndFeel(WindowsClassicLookAndFeelExt.class.getCanonicalName());
        }catch (Exception e){
            e.printStackTrace();
        }

        JFrame frame = new JFrame("JList Test");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] selections = {"<html><img src='http:\\\\invalid\\url'>", "<html><H1>Hello</h1></html>", "orange", "dark blue"};

        JList list = new JList(selections);

        list.setSelectedIndex(1);
        System.out.println(list.getSelectedValue());

        JLabel jLabel = new JLabel("<html><h2>standard Label</h2></html>");
        frame.add(new JScrollPane(list));
        frame.add(jLabel);
        frame.pack();

        frame.setVisible(true);
    }
}