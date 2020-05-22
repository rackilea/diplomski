import java.awt.Component; //import these 3 header files
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class DC extends JFrame {
    public DC() {
        setSize(400, 300);
        setVisible(true);
       // if (getWidth() >= 1000) System.out.print("Thousand");
        addComponentListener(new ComponentAdapter() 
        {  
                public void componentResized(ComponentEvent evt) {
                    Component c = (Component)evt.getSource();
                    if(c.getWidth()>=1000) //This will print Thousand
                    {
                    System.out.println("Thousand");
                    }
                }
        });
    }


    public static void main(String[] args) {
        DC dc = new DC();
        dc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}