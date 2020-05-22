package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BallAnimation
{
    private int x;
    private int y;
    private int count;
    //private int drawPanel.getWidth();
    //private int drawPanel.getHeight();
    private int speedValue;
    private boolean flag;
    /*
     * These variables are used to keep track of 
     * the ball, either it is going LEFT or RIGHT
     * depending on that, we will set the 
     * Co-ordinates.
     */
    private boolean toLeft, toRight;

    private boolean fromTop, fromBottom;

    private Timer timer;

    private JButton button;

    private ActionListener actionTimer; 
    private ActionListener buttonAction;

    MyDraw drawPanel;

    public BallAnimation()
    {
        x = y = count = 0;
        flag = toLeft = false;
        toRight = true;
        fromTop = true;
        fromBottom = false;
        speedValue = 5;
    }

    public static void main(String args[])
    {
        Runnable runnable = new Runnable()
        {
            public void run()
            {
                BallAnimation animation = new BallAnimation();
                animation.go();
            }
        };      
        SwingUtilities.invokeLater(runnable);
    }

    public void go()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JPanel contentPane = new JPanel();

        /*
         * Class Name : 
         * Java Naming Convention says that class names 
         * should be in Pascal Case, i.e. the first
         * letter of the class name should be capitalized
         * and every new word must start with a capitalized 
         * Alphabet.
         * For Example : 
         * public class ClassName{...}
         * ----------------------------------------------------------
         * Variable Name : 
         * Java Naming Convention says that the variable name
         * should be in Camel Case, i.e. the first letter of 
         * the variable name should be small case or _ (underscore)
         * and every new word must start with a capitalized
         * Alphabet.
         * ---------------------------------------------------------
         */
        drawPanel = new MyDraw(0, 0);
        x = drawPanel.getXValue();
        y = drawPanel.getYValue();
        //contentPane.add(drawPanel);

        actionTimer = new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {               
                if (fromTop && !fromBottom && x < drawPanel.getWidth() && y < drawPanel.getHeight() 
                            && toRight && !toLeft)
                {
                    x += speedValue;
                    y += speedValue;
                }
                else if (fromTop && !fromBottom && x < drawPanel.getWidth() && y >= drawPanel.getHeight()
                                 && toRight && !toLeft)
                {
                    /*
                     * Since the ball coming from the TOP LEFT Side
                     * touched the BOTTOM of the JPanel.
                     */
                    y -= speedValue;
                    x += speedValue;
                    fromTop = false;
                    fromBottom = true;
                }
                else if (!fromTop && fromBottom && x < drawPanel.getWidth() && y <= 0
                                  && toRight && !toLeft)
                {
                    /*
                     * Since the ball coming from BOTTOM LEFT Side
                     * touched the TOP of the JPanel. 
                     */
                    fromTop = true;
                    fromBottom = false;
                    x += speedValue;
                    y += speedValue;
                }
                else if (!fromTop && fromBottom && x < drawPanel.getWidth() && y < drawPanel.getHeight()
                                  && toRight && !toLeft)
                {
                    x += speedValue;
                    y -= speedValue;
                }
                else if (!fromTop && fromBottom && x >= drawPanel.getWidth() && y < drawPanel.getHeight()
                                  && toRight && !toLeft)
                {
                    /*
                     * Since the ball coming from the BOTTOM LEFT Side
                     * touched the RIGHT Side of the JPanel.
                     */
                    toRight = false;
                    toLeft = true;
                    x -= speedValue;
                    y -= speedValue;
                }                
                else if (!fromTop && fromBottom && x < drawPanel.getWidth() && y <= 0
                                  && !toRight && toLeft)
                {
                    /*
                     * Since the ball coming from the BOTTOM RIGHT Side
                     * touched the Top Side of the JPanel.
                     */
                    fromTop = true;
                    fromBottom = false;
                    x -= speedValue;
                    y += speedValue;
                }
                else if (fromTop && !fromBottom && x <= 0 && y < drawPanel.getHeight()
                                 && !toRight && toLeft)
                {
                    /*
                     * Since the ball coming from the TOP RIGHT Side
                     * touched the LEFT Side of the JPanel.
                     */
                    toRight = true;
                    toLeft = false;
                    x += speedValue;
                    y += speedValue;
                }
                else if (fromTop && !fromBottom && x >= drawPanel.getWidth() && y < drawPanel.getHeight()
                                  && toRight && !toLeft)
                {
                    /*
                     * Since the ball coming from the TOP LEFT Side
                     * touched the RIGHT Side of the JPanel
                     */
                    toRight = false;
                    toLeft = true;
                    x -= speedValue;
                    y += speedValue;
                }
                else if (fromTop && !fromBottom && x < drawPanel.getWidth() && y < drawPanel.getHeight()
                                  && !toRight && toLeft)
                {
                    x -= speedValue;
                    y += speedValue;
                }
                else if (!fromTop && fromBottom && x <= 0 && y < drawPanel.getHeight()
                                  && !toRight && toLeft)
                {
                    /*
                     * Since the ball coming from the BOTTOM RIGHT Side
                     * touched the LEFT Side of the JPanel.
                     */
                    toRight = true;
                    toLeft = false;
                    x += speedValue;
                    y -= speedValue;
                }
                else if (!fromTop && fromBottom && x < drawPanel.getWidth() && y < drawPanel.getHeight()
                                  && !toRight && toLeft)
                {
                    x -= speedValue;
                    y -= speedValue;
                }
                else if (fromTop && !fromBottom && x < drawPanel.getWidth() && y >= drawPanel.getHeight()
                                  && !toRight && toLeft)
                {
                    /*
                     * Since the ball coming from the TOP RIGHT Side
                     * touched the BOTTOM Side of the JPanel.
                     */
                    fromTop = false;
                    fromBottom = true;
                    x -= speedValue;
                    y -= speedValue;
                }
                System.out.println("X : " + x);
                System.out.println("Y : " + y);
                System.out.println("Direction is LEFT : " + toLeft);
                System.out.println("Direction is RIGHT : " + toRight);
                System.out.println("Coming from TOP : " + fromTop);
                System.out.println("Coming from BOTTOM : " + fromBottom);
                drawPanel.setXYValues(x, y);
            }
        };

        buttonAction = new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if (!flag)
                {
                    timer.start();
                    button.setText("STOP ANIMATION");
                    flag = true;
                }
                else if (flag)
                {
                    timer.stop();
                    button.setText("START ANIMATION");
                    flag = false;
                }
            }
        };

        button = new JButton("START ANIMATION");
        button.addActionListener(buttonAction);

        frame.getContentPane().add(drawPanel, BorderLayout.CENTER);
        frame.getContentPane().add(button, BorderLayout.PAGE_END);
        frame.setSize(300, 300);
        //frame.pack();
        frame.setVisible(true);        

        timer = new Timer(40, actionTimer);
        System.out.println("WIDTH : " + drawPanel.getWidth());
        System.out.println("HEIGHT : " + drawPanel.getHeight());
    }
    class MyDraw extends JComponent
    {
        private int x;
        private int y;
        private Timer timer;

        public MyDraw(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public int getXValue()
        {
            return x;
        }

        public int getYValue()
        {
            return y;
        }

        public void setXYValues(int x, int y)
        {
            this.x = x;
            this.y = y;
            repaint();
        }

        public Dimension getPreferredSize()
        {
            return (new Dimension(300, 300));
        }

        public void paintComponent(Graphics g)
        {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLUE);
            g.fillOval(x, y, 40, 40);
        }
    }
}