import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author roger
 */
public class MyActListener extends JFrame implements ActionListener{

    public MyActListener(){
        super("My Action Listener");

        JButton myButton = new JButton("DisplayAnything");
        myButton.addActionListener(this);
        this.add(myButton);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
        this.setVisible(true);        
    }

    public static void main(String[] args) {
        // TODO code application logic here
        MyActListener ma = new MyActListener();
    }

    @Override
public void actionPerformed(ActionEvent e) { // YOur code for your button here
    if("DisplayAnything".equals(e.getActionCommand())){
        Color c = JColorChooser.showDialog(this, "Color Chooser", Color.BLACK);
        JButton displayAnything = (JButton)e.getSource();
        displayAnything.setBackground(c);
    }
}