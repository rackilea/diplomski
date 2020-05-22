import java.applet.Applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Option3 extends Frame implements ActionListener {

    Button objButton1;
    Button objButton2;
    Button objButton3;
    TextField objTextField;

    Option3() {
        setTitle("Option 3");
        setSize (300,300); // is better to control the frame's size by using panels with appropriate layout managers.

        objButton1 = new Button("A");
        objButton2 = new Button("B");
        objButton3 = new Button("C");
        objTextField = new TextField(100);

        objButton1.addActionListener(this);
        objButton2.addActionListener(this);
        objButton3.addActionListener(this);

        Panel panel = new Panel(); // set a layout to this panel based on how you want the components to be displayed.
        panel.add(objButton1);
        panel.add(objButton2);
        panel.add(objButton3);
        panel.add(objTextField);

        add(panel);

        show();
    }
    public static void main (String args[]) {
        Frame objFrame = new Option3();

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == objButton1 ) { //delimit this kind of statements using curly braces to avoid confusion and bugs.
            System.out.println("A");
        } else if (e.getSource() == objButton2 ) {
            System.out.println("B");
        } else {
            System.out.println("C");    
        }
    }
}