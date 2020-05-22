import javax.swing.*;

public class TestProject {
public static void main(String[] args) {

    JOptionPane.showMessageDialog(null, "Just about to draw the best piece of artwork in my life, need input please.");

    String name= JOptionPane.showInputDialog("Imagine a car, what is it's name?");
    if(name == null || (name != null && ("".equals(name))))   
    {
      System.exit(0);// or you can throw exception
    }
    JOptionPane.showMessageDialog(null, "Ah okay, so it's name is " + name);


    String bodyColour = JOptionPane.showInputDialog("Cool. What colour was the body of the car? \n Blue, Red, Black, Green or Orange? (More to come in DLC's) ");
    JOptionPane.showMessageDialog(null, "Mhmm");

    String wheelColour= JOptionPane.showInputDialog("Colour of the wheels? ");
    JOptionPane.showMessageDialog(null, "Very ordinary...");

    String doorColour = JOptionPane.showInputDialog("Last... And probably least, colour of the door?");
    JOptionPane.showMessageDialog(null, "Finished the drawing!");

 }
}