import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Renderer;
import javax.swing.Timer;
import javax.print.*;

public class Chessstart extends JFrame implements ActionListener, KeyListener
{
    public boolean board_show =true;
    public int AOB1 = 16;
    public int AOB2 = 16;

    public static final int WOB = 640;
    public static final int HOB = 640;

    public int GStat = 0;
    // Defines when game is playing, toggle-able twice 0, 1, 2
    // 0 = Menu, 1 = Paused, 2 = Game
    // Might Become Redundant
    // TODO Make this feature redundant!


    public boolean click, space;
    public int turn;
    public Component renderer;

    public static void main(String[] args) {
        Chessstart ch = new Chessstart();
        //ch.render(ch.getGraphics());
        ch.screenUp();
    }

    public void screenUp()
    {
        Timer timer = new Timer(20, this);
        JFrame jframe = new JFrame("CHESS");

        jframe.setSize(WOB, HOB);
        jframe.setVisible(true);

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(renderer);
        jframe.addKeyListener(this);

        timer.start();
    }

    public void render(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(0, 0, WOB, HOB);
        if (GStat == 0 || GStat == 1 || GStat == 2)
        {
            if (GStat == 0)
            {
                System.out.print("GStat return 0 - Render running");
            }
            if (GStat == 1)
            {
                System.out.print("GStat return 1 - render running");
            }
            if (GStat == 2)
            {
                System.out.print("GStat return 2 - render running");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void keyPressed(KeyEvent arg0){
        // TODO Auto-generated method stub

    }
    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }


}