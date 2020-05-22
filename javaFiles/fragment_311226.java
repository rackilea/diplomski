import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class StockApp extends JFrame {

    public StockApp() {
        // move those unreferenced panels here, so we don't have to reason about them:
        JPanel main = new JPanel();
        JPanel north = new JPanel();
        JPanel center = new JPanel();
        JPanel south = new JPanel();
        // add price later, when name works
        JButton buyStock = new JButton("Buy Stock");
        JLabel stockNameNorth = new JLabel("Stock Name");

        // critical change: Make the label, which you like to update,
        // accessible by whom it should be updated:
        TestTest variables = new TestTest (stockNameNorth);

        setTitle ("StockApp");
        getContentPane().setBackground(Color.white);
        setSize (600,400);
        setLocation (500,200);
        setVisible (true);
        // make the close-frame action terminate the program:
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        main.setLayout (new BorderLayout());
        north.setLayout (new FlowLayout());
        center.setLayout (new FlowLayout());
        south.setLayout (new FlowLayout());
        add (main);
        north.add (stockNameNorth);
        south.add (buyStock);
        main.add (north, BorderLayout.NORTH);
        main.add (center, BorderLayout.CENTER);
        main.add (south, BorderLayout.SOUTH);
    }

    // Main method to start the damn thing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StockApp ();
            }
        });
    }
}

// no need to make this class public in a short test:   
class TestTest extends JDialog implements ActionListener {

    // this are elements, visible outside the construction phase,
    // we need to have access to from more than one method.
    // Make this important distinction visible to the reader: 
    JLabel name;
    JTextField stockNameIn = new JTextField (5);
    JButton buttonOK = new JButton ("OK");

    // add the JLabel to update to the ctor, so that it can't be forgotten
   // to be set
    public TestTest (JLabel pname) {
        // we copy the reference to the label, to have access to it in 
        // the actionPerformed method.
        name = pname;
        JPanel main = new JPanel();
        JPanel north = new JPanel();
        JPanel center = new JPanel();
        JPanel south = new JPanel();
        JLabel stockNameLabel = new JLabel ("Stock name: ");
        getContentPane().setBackground(Color.white);
        // different size/location than frame, so that they don't hide
        // each other completly
        setSize (400,600);
        setLocation (700,300);
        setModal (false);
        setVisible (true);
        getRootPane().setDefaultButton(buttonOK);
        main.setLayout (new BorderLayout());
        north.setLayout (new FlowLayout());
        center.setLayout (new FlowLayout());
        south.setLayout (new FlowLayout());
        add (main);
        north.add (stockNameLabel);
        north.add (stockNameIn);
        south.add (buttonOK);
        main.add (north, BorderLayout.NORTH);
        main.add (center, BorderLayout.CENTER);
        main.add (south, BorderLayout.SOUTH);
        buttonOK.addActionListener(this);
    }

    // here we need access to the button - was it the OK-Button, clicked?    
    // and the textfield stockNameIn, to read the text 
    // and the name field from the frame, to set the text 
    public void actionPerformed(ActionEvent e) {
        if (e.getSource () == buttonOK) {
            name.setText (stockNameIn.getText());
            dispose();
        }
    }
}