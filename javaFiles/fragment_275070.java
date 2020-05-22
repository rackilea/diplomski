import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame
{
    public static void main ( String [] args )
    {
        MyFrame myframe = new MyFrame();
        myframe.setSize( 300, 300 );
        myframe.setResizable( false );
        myframe.setLocationRelativeTo( null );
        myframe.setLayout( new GridLayout(3,3) );

        Container container = myframe.getContentPane();
        ArrayList < JPanel > components = new ArrayList < JPanel >();
        JPanel temp = null;

        // Populating Arraylist object.
        for ( int i = 0; i < 9; i++ )
        {
            temp = new JPanel();
            temp.setSize( 100,100 );
            components.add( temp );
            container.add(temp);
        }

        myframe.pack();
        myframe.setVisible( true );

        // Accessing components via index.
        components.get( 5 ).setBackground( Color.BLUE );
        components.get( 8 ).setBackground( Color.GREEN );
    }
}