import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  
public class TestBtnMain {

    public static void main(String[] args) {
        TestBtn btn = new TestBtn();
        JButton newBtn = btn.myBtn();

        newBtn.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                System.out.println("Success");
            }  
        });


    }
}