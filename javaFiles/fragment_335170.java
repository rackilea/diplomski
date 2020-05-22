import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

//Here's a class for a simple GUI that uses a JFrame
//to hold to JTextAreas - one will listen for the key events
//and the other will sit inside a JScrollPane providing feedback
//about the KeyListener events being triggered

public class KeyListenerExample {

    JTextArea inputText;
    JTextArea feedbackText;

     //Note: Typically the main method will be in a
    //separate class. As this is a simple one class
    //example it's all in the one class.
    public static void main(String[] args) {


         //Use the event dispatch thread for Swing components
         EventQueue.invokeLater(new Runnable()
         {

            @Override
             public void run()
             {

                 new KeyListenerExample();         
             }
         });

    }

    public KeyListenerExample()
    {
        JFrame guiFrame = new JFrame();

        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Creating a Table Example");
        guiFrame.setSize(700,200);

        //This will center the JFrame in the middle of the screen
        guiFrame.setLocationRelativeTo(null);

        //This JTextArea is used to display information about
        //the keylistener events. It's place in a JScrollPane
        //to allow the scrolling through all the events triggered
        feedbackText = new JTextArea();
        JScrollPane scrollText = new JScrollPane(feedbackText);

        //This JTextArea will trigger the KeyListener events as
        //long as it hold the focus
        inputText = new JTextArea();

        //The KeyListener interface is implemented as an anonymous
        //inner class using the addKeyListener method.
        inputText.addKeyListener(new KeyListener()
        {
              //When any key is pressed and released then the 
              //keyPressed and keyReleased methods are called respectively.
              //The keyTyped method is called when a valid character is typed.
              //The getKeyChar returns the character for the key used. If the key
              //is a modifier key (e.g., SHIFT, CTRL) or action key (e.g., DELETE, ENTER)
              //then the character will be a undefined symbol.
              @Override 
              public void keyPressed(KeyEvent e)
              {
                  feedbackText.append("Key Pressed: " + e.getKeyChar() + "\n");
              }
              @Override
              public void keyReleased(KeyEvent e)
              {
                  feedbackText.append("Key Released: " + e.getKeyChar() + "\n");
              }

              @Override
              public void keyTyped(KeyEvent e)
              {
                  //The getKeyModifiers method is a handy
                  //way to get a String representing the
                  //modifier key.
                  feedbackText.append("Key Typed: " + e.getKeyChar() + " " + KeyEvent.getKeyModifiersText(e.getModifiers()) + "\n");
              }
        });

        guiFrame.add(inputText, BorderLayout.NORTH);
        guiFrame.add(scrollText, BorderLayout.CENTER);
        guiFrame.setVisible(true);
    }

}