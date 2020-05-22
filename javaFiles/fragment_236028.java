import java.awt.BorderLayout;
import javax.swing.*;

public class testSetText extends JFrame 
{
    private JPanel          panel;
    private JTextField      singleField;
    // Make array of JTextField components
    private JTextField[] arrayField = new JTextField[2];

    public testSetText()
    {
        // Specify an action for close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make a panel
        panel = new JPanel();

        for (int i = 0; i < 2; i++)
        {
            arrayField[i] = new JTextField(10);
            arrayField[i].setEditable(false);
            arrayField[i].setText("<>!");
            panel.add(arrayField[i]);
        }

        // Make just one JTextField component
        singleField = new JTextField(10);
        singleField.setText("Works here");
        panel.add(singleField);

        // Add to panel to frame
        add(panel);

        // Pack the contents of the window and display it
        pack();
        setVisible(true);

        // This will work!
        arrayField[0].setText("Array index in class");

        // This won't? Why?
        setInMethodWithArray();

        // Is this a problem with JTextField itself? Let me try a single element
        setInMethodWithArray(); 

        // Hmmm so an element in an array of JTextFields can be addressed with setText in a class but not 
        // in a method in same class with same statement. But a single JTextField can be used in a method
        // by that same class. Why do arrays behave so differently?
    }

    public void setInMethodWithArray()
    {
        arrayField[1].setText("This text will never show up");
    }

    public void setInMethodWithSingleElement()
    {
        singleField.setText("Works here as non-array");
    }

    public static void main(String[] args)
    {
        new testSetText();
    }
}