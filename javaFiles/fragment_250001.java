import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Testgui1 extends JFrame implements ActionListener //Alist visar vad
//som görs när man utför ett klick
{
    int i = 1;
    int two = 11;
    JLabel myLabel = new JLabel();//Ny panelen
    JPanel mypanel = new JPanel();
    JButton mybutton = new JButton("1-10");
    JButton mybutton2 = new JButton("10-1");
    Testgui1()
    {
        super("Meny");
        setSize(200,200);//Storlek på frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//stänger ner rutan vid X
        Container con = this.getContentPane();//ärver mainframe
        con.add(mypanel);
        mybutton.addActionListener(this);
        mybutton2.addActionListener(this);
        mypanel.add(myLabel);
        mypanel.add(mybutton);
        mypanel.add(mybutton2);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent event)
    {
       Object source = event.getSource();
        if (source == mybutton)
       {
        StringBuilder usual = new StringBuilder();
        while(i < 11) {
        usual.append(" ").append(i);
            i++;
                     }
        JOptionPane.showMessageDialog(null, usual, "1-10",
             JOptionPane.PLAIN_MESSAGE);
                 setVisible(true);}
     {
     if (source == mybutton2)
        {
    StringBuilder reverse = new StringBuilder();
        while (two > 0) {
        reverse.append(" ").append(two);
        two--;
}
        JOptionPane.showMessageDialog(null,reverse,"10-1",
                JOptionPane.PLAIN_MESSAGE);
                setVisible(true);
}}}
  public static void main(String[] args) {new Testgui1();}
}