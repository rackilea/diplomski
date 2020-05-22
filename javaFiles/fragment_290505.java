import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ObserverFrame extends JFrame {

  Panel1 panel;
  JPanel panel2;
  JLabel label;

 //to kick off the example
public static void main(String args[]){
    new ObserverFrame();        
}

//constructor of the JFrame
public ObserverFrame(){
    super("Observer Example");

    //the panel that we want to observe
    //notice that we pass a reference to the parent
    panel = new Panel1(this);
    add(panel, BorderLayout.NORTH);

    //another panel to be updated when the property changes
    panel2 = new JPanel();
    label = new JLabel("Panel to be updated");

    panel2.add(label);

    add(panel2, BorderLayout.SOUTH);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 500);
    setVisible(true);
}

//this method will be called by the panel when the property changes.
public void trigger(Panel1 panel) {
    label.setText(String.valueOf(panel.getProperty()));
}


//inner class for convenience of the example
class Panel1 extends JPanel{
    ObserverFrame parent;
    JButton b1;
    private int property;

    //accept the parent
    public Panel1(ObserverFrame p){
        this.parent = p;
        b1 = new JButton("Click Me");
        //click the button to change the property
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setProperty(getProperty() * 2); //update property here
            }
        });
        property = 10;
        add(b1);
    }

    //the property that we care about
    public int getProperty() {
        return property;
    }

    //when the setter is called, trigger the parent
    public void setProperty(int property) {
        this.property = property;
        parent.trigger(this);
    }


  }

}