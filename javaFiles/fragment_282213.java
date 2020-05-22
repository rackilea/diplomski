import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;

public class GUIBuilder extends JFrame
{
    private JPanel orderList;
    private JPanel orderListRow;
    private JPanel additionalPanel;

    private List panels = new ArrayList(); //Your List

    private JLabel label1, label2, label3;

    public GUIBuilder()
    {
        label1 = new JLabel("Label 1"); //Create the JLabels
        label2 = new JLabel("Label 2");//Create the JLabels
        label3 = new JLabel("Label 3");//Create the JLabels


        orderList = new JPanel(); //Creating the orderList JPanel
       orderList.setLayout(new BoxLayout(orderList, BoxLayout.Y_AXIS)); //Setting Box layout, and set the direction to Y axis.


        orderListRow = new JPanel(); //Creating the orderListRow JPanel        
        orderListRow.add(label1);

        additionalPanel = new JPanel(); //Creating the additionalPanel JPanel      
        additionalPanel.add(label2);

        orderList.add(orderListRow); //Adding orderListRow into orderList
        orderList.add(additionalPanel); //Adding additionalPanel into orderList

        this.setLayout(new GridLayout(1,1));
        this.add(orderList); //Setting orderList into JFrame

        this.pack(); //Setting JFrame size. This will only take required space
        this.setVisible(true); //Making JFrame Visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //When you hit the 'X' button, the program will exit
    }

    public static void main(String[]args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //Setting the UI into your native platform UI
            new GUIBuilder(); //Calling your program
        }
        catch(Exception e)
        {
            e.printStackTrace(); //If any error occured in setting up UI, print the stack trace
        }
    }
}