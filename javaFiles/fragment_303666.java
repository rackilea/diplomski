import javax.swing.*;
import java.awt.*;

public class RadioButtonWindow extends JFrame{
    public JRadioButton radio1= new JRadioButton("Salam1");
    public JRadioButton radio2= new JRadioButton("Salam2");
    public JRadioButton radio3= new JRadioButton("Salam3");

    public RadioButtonWindow(){
        super("Title");
        setLayout(new FlowLayout());

        add(radio1);
        add(radio2);
        add(radio3);

        // Only one button in this group can be selected at a time!
        ButtonGroup bg = new ButtonGroup();
        bg.add(radio1);
        bg.add(radio2);
        bg.add(radio3);
    }

   public static void main(String args[]) {
        RadioButtonWindow  salam = new RadioButtonWindow ();
        salam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Wrong way to size a GUI!
        //salam.setSize(500,150);
        salam.setResizable(false);
        // Correct way to size a GUI
        salam.pack();
        salam.setVisible(true);
    }
}