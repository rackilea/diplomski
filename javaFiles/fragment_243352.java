package com.digital.core;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Test {

    public static void main(String[] args) {
       JFrame jframe = new JFrame();
       jframe.setSize(300, 300);
       String data = "id,from,\n" + 
            "1,Jakarta\n" + 
            "2,Jakarta\n" + 
            "5,Jakarta\n" + 
            "6,Jakarta\n" + 
            "10,Bandung\n" + 
            "11,Bandung\n" + 
            "12,Bandung";
       String[] dataArr = data.split("\n");

       Set<String> locationSet = new HashSet<>();
       for(String line:dataArr) {
           locationSet.add(line.split(",")[1]);
       }
       JComboBox<String> comboBox = new JComboBox<>();
       for(String location:locationSet)
       comboBox.addItem(location);
       jframe.add(comboBox);
       jframe.setVisible(true);


    }


}