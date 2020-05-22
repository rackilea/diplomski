import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private JFrame frame;

    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                new Main();                                 //Create a Main object, wrapped by SwingUtilities.invokeLater to make it thread safe
            }
        });

    }

    public Main() {                                         //Main's constructor

        frame = new JFrame();                               //Create JFrame
        frame.setTitle("Test Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init((JPanel)frame.getContentPane());               //'init' frame's JPanel
        setFrameSizeAndPos(frame);                          //Set the frame's size

        frame.setVisible(true);
    }

    private void setFrameSizeAndPos(JFrame frame) {

        //Set JFrame size here! Eg:
        frame.pack();                                       //Set the frame size, you could change this to set it in a different way.
        frame.setLocationRelativeTo(null);                  //Place frame in the center of the screen
    }

    private void init(JPanel panel) {
        //Setup your GUI here...
        JButton button1 = new JButton("Click me!");         //Create button
        button1.addActionListener(new ActionListener(){     //add an ActionListener to the button, passing in an Anonymous Class

            @Override
            public void actionPerformed(ActionEvent e) {
                setFrameSizeAndPos(frame);                  //This will be called then the button is pressed
            }
        });

        panel.add(button1);

    }
}