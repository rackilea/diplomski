import java.awt.event.*;  
import javax.swing.*;    
public class TestBtn { 

    TestBtn() {

    }
    public JButton myBtn(){   

        JFrame f=new JFrame("My Example");   

        JButton mybtn =new JButton("Click Here");  
        mybtn.setBounds(50,100,95,30);  

        f.add(mybtn);  
        f.setSize(400,400);  
        f.setLayout(null);  
        f.setVisible(true);   
        return mybtn;
    } 

}