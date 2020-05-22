package pkTopic5T6;
 import javax.swing.*;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.Color;
import java.awt.Font;
 public class Topic5T6
{
public JComboBox cboDisplayList;
public static void main(String[] args) 
{
    Topic5T6 My56 = new Topic5T6();
    My56.go();
}
public void go()
{
    GUI56 My56 = new GUI56();
    populateList Mypop = new populateList();
    Mypop.grabItems();
    My56.addText1();
    System.out.println("end");
}
class GUI56 extends JFrame
{
    JLabel lblHeading;
    JTextField  textField;
    protected  GUI56()
    {
        this.setSize(600,500);
        this.setLocation(100,100);
        this.setTitle("56");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        Font f1 = new Font("Monospaced",Font.BOLD,32);
        Font f2 = new Font("Dialog",Font.BOLD,32);
        lblHeading = new JLabel("Testing Combo");
        lblHeading.setBounds(10,10,300,50);
        lblHeading.setFont(f2);
        this.add(lblHeading);
        cboDisplayList = new JComboBox();
        cboDisplayList.setBounds(10,70,300,50);
        cboDisplayList.setBackground(Color.PINK);
        cboDisplayList.setFont(f1);
        this.add(cboDisplayList);
        textField=new JTextField("test");
       // this.add(new JTextField(cboDisplayList.getItemAt(0)+" test"));
         this.setVisible(true);

    }
    public void addText1()
    {

         textField.setText(cboDisplayList.getItemAt(4)+"");
         textField.setBounds(20,150,180,90);
         textField.setVisible(true);
         System.out.println("set text");
        this.add(textField);
    }
}
class populateList
{
    protected int k;
    protected populateList()
    {}
    protected void grabItems()
    {
        for (k=1; k<= 20; k =k+1)
        {
            cboDisplayList.addItem("Dummy Item " + k);
        }
       }
    }
}