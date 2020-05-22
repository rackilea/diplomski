/**
 * 
 *@author ngc5043
 *@version 1.0 
 */

import javax.swing.*;
import java.awt.event.*;

public class Nicolas_Carabajal_Assignment3 extends JFrame
{
    private JPanel panel;
    private JLabel messageLabel;
    private JTextField ExTextField;
    private JButton calcButton;
    private final int WINDOW_WIDTH = 310;
    private final int WINDOW_HEIGHT = 100;


 public static void main(String[] args)
  {
      Nicolas_Carabajal_Assignment3 main = new Nicolas_Carabajal_Assignment3();

  }
  public Nicolas_Carabajal_Assignment3()
  {
      buildPanel();
    setTitle("Expressions Window");
    setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    add(panel);
    setVisible(true);
  }

   private void buildPanel()
   {
       messageLabel = new JLabel("Please Enter a Number");
       ExTextField = new JTextField(10);
       calcButton = new JButton("Calculate");

       panel = new JPanel();
       panel.add(messageLabel);
       panel.add(ExTextField);
       panel.add(calcButton);
       calcButton.addActionListener(new CalcButtonListener());
   }

   private class CalcButtonListener implements ActionListener
  {
      public void actionPerformed(ActionEvent e)
       {
           String input;
           int num_ent = 0;


           input = ExTextField.getText();

           System.out.println(input);

           double answerOne = Double.parseDouble(input);
           System.out.println(answerOne);
           answerOne = num_ent * num_ent;
           JOptionPane.showMessageDialog(null, "Your Answer Is" + answerOne);

        /**
        * here i would like to add another function. input*(n+1.0)/2.0
        *Getting the same number from the user and calculating this aswell. 
        */ 



       }

   }


}