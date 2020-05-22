import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class ShapesTest {

    public static void main( String args[] ){

        Shapes panel     = new Shapes();
        JFrame app       = new JFrame();
        JLabel statusBar = new JLabel();

        statusBar.setSize(400, 20);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(panel);
        app.add(statusBar, BorderLayout.SOUTH);
        app.setSize( 400, 400 );
        app.setVisible(true);

        statusBar.setText(panel.status());

    }

}

import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Random;

public class Shapes extends JPanel{
    private static final int TYPE_LINE = 0;
    private static final int TYPE_RECT = 1;
    // private static final int TYPE_OVAL = 2; // not used
    private int[] forms = new int[10];

    private int c = 0, r = 0, l = 0;

    public Shapes() {
        super();

        Random rand = new Random();

        for(int i = 0; i < forms.length; i++) {
            int choice = rand.nextInt(3);

            if(choice == TYPE_LINE)
                c++;
            else if(choice == TYPE_RECT)
                r++;
            else
                l++;  

            forms[i] = choice;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int x = 10;
        int y = 10;

        for(int i = 0; i < forms.length; i++) {
            int choice = forms[i];

            if(choice == TYPE_LINE){
                g.drawLine(x, y, i*10+50, i+100);
            }

            else if(choice == TYPE_RECT){
                g.drawRect(i*20, y*20, x*10, y *10);
            }

            else {
                g.drawOval(x*10, i*20, x*10, y*10);    
            }

            x+=5;
            y+=5;
        }
    }

    public String status(){        
        String message = String.format("C:%d;R:%d;L:%d", c, r, l);
        return message;
    }
}