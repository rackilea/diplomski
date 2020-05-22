import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class TextAreaDemo
{
JTextArea jta;
TextAreaDemo()
{
JFrame jfrm=new JFrame("Text Area");
jfrm.setSize(200,300);
jfrm.getContentPane().setLayout(new FlowLayout());
jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

jta=new JTextArea("Type Here");

//You can use this line to wrap that text when it extends on right side.
//jtxt.setLineWrap(true);


JScrollPane jscrp=new JScrollPane(jta);
jscrp.setPreferredSize(new Dimension(180,100));
jscrp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


jfrm.add(jscrp);
jfrm.setVisible(true);

}

public static void main(String args[])
{
 SwingUtilities.invokeLater(new Runnable(){public void run(){new TextAreaDemo();}});
}
}