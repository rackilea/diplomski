import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class qwerty implements DocumentListener{

ArrayList<JTextField> tfs = new ArrayList<JTextField>();
ArrayList<JButton> bts = new ArrayList<JButton>();


int counter = 0;
String answer;
JLabel j1 = new JLabel("Mark");
JLabel j2 = new JLabel("Joe");
JLabel j3 = new JLabel("John");
JLabel j4 = new JLabel("Ray");

JButton b1 = new JButton("Button1");
JButton b2 = new JButton("Button2");
JButton b3 = new JButton("Button3");
JButton b4 = new JButton("Button4");

public static void main(String[] args) {
   EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
        new qwerty();
        }
    });
}
public qwerty() {

JFrame frame = new JFrame();
frame.getContentPane().setLayout(new FlowLayout());

// Add new buttons to bts
bts.add(b1);
bts.add(b2);
bts.add(b3);
bts.add(b4);

Add new textfields to tfs
tfs.add(new JTextField());
tfs.add(new JTextField());
tfs.add(new JTextField());



   j1.setPreferredSize(new Dimension(100, 25));
   j2.setPreferredSize(new Dimension(100, 25));
   j3.setPreferredSize(new Dimension(100, 25));
   j4.setPreferredSize(new Dimension(100, 25));


for (JButton b : bts) {
    b.addActionListener(new ButtonActionListener());
    b.setPreferredSize(new Dimension(100, 25));
    frame.getContentPane().add(b);
}

    frame.getContentPane().add(j1);
    frame.getContentPane().add(j2);
    frame.getContentPane().add(j3);
    frame.getContentPane().add(j4);



for (JTextField tf : tfs) {
    tf.setPreferredSize(new Dimension(100, 25));
    tf.setEditable(false);
    tf.getDocument().addDocumentListener( this );
    frame.getContentPane().add(tf);

}


frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(500, 500);
frame.setVisible(true);

}
        public boolean isDataEntered1()
    {

    for (JTextField tf : tfs)
    {

        if ("Mark".equals(tf.getText()))
            return false;
    }

    return true;
}

    public boolean isDataEntered2()
{

    for (JTextField tf : tfs)
    {

        if ("Joe".equals(tf.getText()))
            return false;
    }

    return true;
}

     public boolean isDataEntered3()
{

    for (JTextField tf : tfs)
    {

        if ("John".equals(tf.getText()))
            return false;
    }

    return true;
}

     public boolean isDataEntered4()
{

    for (JTextField tf : tfs)
    {

        if ("Ray".equals(tf.getText()))
            return false;
    }

    return true;
}


@Override
public void insertUpdate(DocumentEvent e) {
   checkData();
}

@Override
public void removeUpdate(DocumentEvent e) {
    checkData();
}

@Override
public void changedUpdate(DocumentEvent e) {}

private void checkData()
{
    b1.setEnabled(isDataEntered1());
    b2.setEnabled(isDataEntered2());
    b3.setEnabled(isDataEntered3());
    b4.setEnabled(isDataEntered4());
}

 public class ButtonActionListener implements ActionListener {


@Override
public void actionPerformed(ActionEvent e) {
    if (counter >= tfs.size()) {
        counter = 0;
    }

    String a = ((AbstractButton) e.getSource()).getText();
    if (a == "Button1"){
    tfs.get(counter).setText(j1.getText());
    }   

    if (a == "Button2"){
    tfs.get(counter).setText(j2.getText());
    }

    if (a == "Button3"){
    tfs.get(counter).setText(j3.getText());
    } 

    if (a == "Button4"){
    tfs.get(counter).setText(j4.getText());
    } 

    counter++;
}