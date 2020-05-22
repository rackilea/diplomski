import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class caseconversion extends JFrame{

    private JTextField tf;
    private JCheckBox boldbox;
    private JCheckBox italicbox;
    private JButton up;
    private JButton low;

    public caseconversion(){

        super ("Case Converter");
        setLayout(new GridLayout(0,1));

        JPanel p = null;

        p = new JPanel();
        tf=new JTextField("Hello whats up Buddy !!",25);
        tf.setFont(new Font("Segoe Print",Font.PLAIN,15));
        p.add(tf);
        add(p);

        p = new JPanel();
        boldbox = new JCheckBox("Bold");
        italicbox = new JCheckBox("Italic");
        p.add(boldbox);
        p.add(italicbox);
        add(p);

        p = new JPanel();
        up=new JButton("Upper Case");
        low=new JButton("Lowercase");
        p.add(up);
        p.add(low);
        add(p);

        HandlerClass handler = new HandlerClass();
        boldbox.addItemListener(handler);
        italicbox.addItemListener(handler);
        up.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    tf.setText(tf.getText().toUpperCase());
                }
            }
            );
        low.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    tf.setText(tf.getText().toLowerCase());
                }
            }
            );           
    }

    private class HandlerClass implements ItemListener {
        //For Checkboxes
        public void itemStateChanged(ItemEvent event){
            Font font= null;

            if(boldbox.isSelected()&&italicbox.isSelected())
                font = new Font("Segoe Print",Font.BOLD + Font.ITALIC ,15);
            else if(boldbox.isSelected())
                font = new Font("Segoe Print",Font.BOLD ,15);
            else if(italicbox.isSelected())
                font = new Font("Segoe Print",Font.ITALIC ,15);
            else
                font= new Font("Segoe Print",Font.PLAIN,15);

            tf.setFont(font);

        }
    }
    public static void main(String arg[]){

        caseconversion go = new caseconversion();
        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        go.setSize(400,250);
        go.setVisible(true);
    }

}