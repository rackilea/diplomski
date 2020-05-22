import java.io.*;
import javax.swing.*;
public class DetectWin extends JFrame
{
    JPanel loginPnl = new JPanel();
    JTextField Dfield = new JTextField("", 20);

    DetectWin()
    {
        super("AUTHORIZATION");
        setSize(350, 100);
        setLocation(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(loginPnl);
        setVisible(true);
        setResizable(false);

        loginPnl.add(Dfield);
        String[] letters = new String[]{ "A", "B", "C", "D", "E", "F", "G", "H", "I", "Z"};
        File[] drives = new File[letters.length];
        boolean[] isDrive = new boolean[letters.length];

        for ( int i = 0; i < letters.length; ++i )
            {
            drives[i] = new File(letters[i]+":/");

            isDrive[i] = drives[i].canRead();
            }

         Dfield.setText("Waiting for devices....");

         while(true)
            {
            for ( int i = 0; i < letters.length; ++i )
                {
                boolean pluggedIn = drives[i].canRead();

                if ( pluggedIn != isDrive[i] )
                    {
                    if ( pluggedIn )
                        Dfield.setText("Drive "+letters[i]+" has been plugged in");
                    else
                        Dfield.setText("Drive "+letters[i]+" has been unplugged");

                    isDrive[i] = pluggedIn;
                    }
                }

            try { Thread.sleep(100); }
            catch (InterruptedException e) { }
            }
    }
    public static void main(String args[])
    {
        DetectWin AUTHORIZATION = new DetectWin();
    }
}