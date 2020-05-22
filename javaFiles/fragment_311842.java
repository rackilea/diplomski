import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// <applet code='MathewBorumGame' width=400 height=400></applet>
public class MathewBorumGame extends JApplet
{
    public void init()
    {
        Dimension dim = getSize();
        MathewBorumGamePanel avoidance = new MathewBorumGamePanel(dim);
        add(avoidance);
        /*
        Thread game = new Thread(avoidance);
        game.start();*/
    }
}// end of the extended JApplet class

class MathewBorumGamePanel extends JPanel { //implements Runnable{
    protected int x = 225;
    protected int y = 450;
    private int speed = 0;
    private boolean isPlaying = false;
    private boolean hasHit = false;
    private String instructions = "Press 'Enter' to start survive as long as"
        + " as possible.";
    private String keyInstructions = "Use arrow keys to move.";
    private String test;
    private Dimension dim = null;
    private Thread game = null;
    private Timer timer = new Timer(1000, new TimerListener());
    public MathewBorumGamePanel(Dimension paramDimension) {
        this.dim = paramDimension;
        setBackground(new Color(255, 255, 204));
        setForeground(Color.black);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                        switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        System.out.println("Go left");
                        if(x >= 10) x = x - 10;
                        repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        System.out.println("Go right");
                        if(x <= 490) x = x + 10;
                        repaint();
                        break;
                    default:
                        //repaint();
                        break;
                }
            }
        });
        // Must be focusable!
        setFocusable(true);
        // very important!  Must have focus..
        requestFocusInWindow();
        timer.start();
    }

    /*  THIS IS NOT HOW TO DO ANIMATION!
    @Override
    public void run() {
        for (;;) {
            repaint();
        }
    }*/

    public void paintComponent(Graphics paramGraphics) {
        super.paintComponent(paramGraphics);
        paramGraphics.fillRect(x, y, 50, 15);
        paramGraphics.setFont(new Font("Serif", Font.BOLD, 15));
        paramGraphics.drawString(this.instructions, 30, 30);
        paramGraphics.drawString(this.keyInstructions, 30, 50);
        test = test.valueOf(x);
        paramGraphics.drawString(test, 30, 70);
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }
}//end of the extended JPanel class