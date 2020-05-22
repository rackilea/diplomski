import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Dynamic_Bg_Color extends JPanel{

private static final long serialVersionUID = 1L;

static Dimension size = new Dimension(500,400);

static JFrame frame;

public Dynamic_Bg_Color(){

    setPreferredSize(size);
    setBackground(Color.cyan);
    addMouseListener(new Handler());

}

@Override
public void paintComponent(Graphics g){

    System.out.println("Click");

    super.paintComponent(g);

    g.setColor(Color.blue);
    g.fillRect(20,20,getWidth()-40,100);

    g.setColor(Color.green);
    g.fillRect(20,140,getWidth()-40,100);

    g.setColor(Color.orange);
    g.fillRect(20,260,getWidth()-40,100);
}

public static void main(String[] args){     


    Dynamic_Bg_Color d = new Dynamic_Bg_Color();

    frame = new JFrame("BG Color Changer");

    frame.setPreferredSize(new Dimension(size));
    frame.setMinimumSize(new Dimension(size));
    frame.setMaximumSize(new Dimension(size));
    frame.setLayout(new FlowLayout());
    frame.setLocationRelativeTo(null);
    frame.add(d);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(Color.cyan);
    frame.setVisible(true);

    }

public class Handler extends MouseAdapter{

    public void mousePressed(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        if(x>= 20 && x<=getWidth()-40 && y>=20 && y<= 120){
            frame.getContentPane().setBackground(Color.blue);
            setBackground(Color.blue);
            frame.setTitle("Blue");
        }
        if(x>= 20 && x<=getWidth()-40 && y>=140 && y<= 240){
            frame.getContentPane().setBackground(Color.green);
            setBackground(Color.green);
            frame.setTitle("Green");    
            }
        if(x>= 20 && x<=getWidth()-40 && y>=260 && y<= 360){
            frame.getContentPane().setBackground(Color.orange);
            setBackground(Color.orange);
            frame.setTitle("Orange");
            }
    }



}

}