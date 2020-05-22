import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Test extends JFrame{

    Action actOne = new AbstractAction("One"){
        public void actionPerformed(ActionEvent e){
            ((JButton)e.getSource()).setAction(actTwo);
        }
    };

    Action actTwo = new AbstractAction("Two"){
        public void actionPerformed(ActionEvent e){
            ((JButton)e.getSource()).setAction(actThree);
        }
    };

    Action actThree = new AbstractAction("Three"){
        public void actionPerformed(ActionEvent e){
            ((JButton)e.getSource()).setAction(actOne);
        }
    };

    public Test(){
        super("Test");
        setLayout(new BorderLayout());
        add(new JButton(actOne), BorderLayout.CENTER);
        setSize(160,120);
    }

    public static void main(String[]args){
        new Test().show();
    }
}