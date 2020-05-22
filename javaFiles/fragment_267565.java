import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JComponentLayout extends JFrame implements KeyListener{
    JLabel cmd1;
    JButton add1;
    JTextField cmdtext1;
    JButton delete1;
    JLabel examplelabel;


    Vector<Component> fields = new Vector<Component>(15);
    JPanel commandpanel = new JPanel(new FlowLayout());
   public static void main(String [] args){
       new JComponentLayout();
   }
   public JComponentLayout(){
  cmd1=new JLabel("Command");
    cmd1.setBounds(20, 76, 70, 30);
    cmd1.setFont(new Font("serif",Font.BOLD,13));
    commandpanel.add(cmd1);

    cmdtext1=new JTextField();
    cmdtext1.setBounds(80, 80,70,25);
    commandpanel.add(cmdtext1);

    examplelabel=new JLabel("Enter HexaDecimal values (For example : 45,1E) ");
    examplelabel.setBounds(260, 50, 250,25);
    examplelabel.setFont(new Font("serif",Font.PLAIN,12));
    commandpanel.add(examplelabel);


    for(int e = 0;  e < 15; ++e){
        JTextField command = new JTextField(2);
        command.addKeyListener(this);
        commandpanel.add(command);
        fields.add(command);
    }


    delete1=new JButton("Delete");
    delete1.setBounds(606, 80, 70, 25);
    commandpanel.add(delete1);


    add1=new JButton("Add");
    add1.setBounds(547, 80,56,25);
    add1.addActionListener(new ActionListener()
    {

        @Override
        public void actionPerformed(ActionEvent e){
            // TODO Auto-generated method stub
        }

    });

    commandpanel.add(add1);
    this.add(commandpanel);
    this.setVisible(true);
   }



    @Override
    public void keyTyped(KeyEvent e) 
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e){
        JTextField source = (JTextField)e.getSource();

        // TODO Auto-generated method stub
        if(source.getText().length() == 2){
            fields.get((1 + fields.indexOf(source)) 
            % fields.size()).requestFocus();
        }       
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        // TODO Auto-generated method stub

    }
}