import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Random;

public class Gravity extends JPanel {

    public static final int screenw = 800;
    public static final int screenh = 600;

    public static Random gen = new Random();

    public static int[] starx = new int[100];
    public static int[] stary = new int[100];
    public static Color[] starc = new Color[100];

    public static Image buffer;
    public static Graphics bg;

    public static int[] xh = new int[1000];
    public static int[] yh = new int[1000];

    public static int i = 0;

    public static ArrayList<Integer> ptx = new ArrayList<Integer>();
    public static ArrayList<Integer> pty = new ArrayList<Integer>();
    double x = 100;
    double y = 100;

    Timer timer;

    public Gravity(){
        // set thre PREFERRED size!
        setPreferredSize(new Dimension(screenw, screenh));
        addMouseListener(new MouseListener(){
                    public void mouseClicked(MouseEvent e){
                        System.out.println("Mouse was clicked");
                        timer.start();
                    }

                    public void mouseEntered(MouseEvent arg0) {}
                    public void mouseExited(MouseEvent arg0) {}
                    public void mousePressed(MouseEvent arg0) {}
                    public void mouseReleased(MouseEvent arg0) {}
        });
        ActionListener animation = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                repaint();
            }
        };
        timer = new Timer(50, animation);
    }

    @Override
    public void paintComponent(Graphics g) {
        buffer = createImage(screenw, screenh);
        bg = buffer.getGraphics();

        int w = getWidth();
        int h = getHeight();

        double px = getWidth()/2;
        double py = getHeight()/2;

        bg.setColor(Color.BLACK);
        bg.fillRect(0, 0, w, h); //black background

        for (int j=0; j < 100; j++){ //make stars
            starx[j] = gen.nextInt(w);
            stary[j] = gen.nextInt(h);
            starc[j] = new Color(gen.nextInt(100)+156, gen.nextInt(100)+156, gen.nextInt(100)+156);
            bg.setColor(starc[j]);
            bg.drawLine(starx[j], stary[j], starx[j]+2, stary[j]+2);
            bg.drawLine(starx[j], stary[j]+2, starx[j]+2, stary[j]);
        }

        g.drawImage(buffer, 0, 0, null);

        double xvel = -15;
        double yvel = 10;

        for (int j=0; j < 100; j++){ //store stars
            starx[j] = gen.nextInt(w);
            stary[j] = gen.nextInt(h);
            starc[j] = new Color(gen.nextInt(100)+156, gen.nextInt(100)+156, gen.nextInt(100)+156);
        }

        Image test = createImage(200,200);
        Graphics testg = test.getGraphics();
        testg.drawLine(50,50,150,150);

        g.drawImage(buffer, 0,0, null);
        try {
            Thread.sleep(33);
        } catch (Exception e) {
            e.printStackTrace();
        }

        bg.setColor(Color.BLACK);
        bg.fillRect(0, 0, w, h); //black background


        for (int j=0; j < 100; j++){ //draw stars
            bg.setColor(starc[j]);
            bg.drawLine(starx[j], stary[j], starx[j]+2, stary[j]+2);
            bg.drawLine(starx[j], stary[j]+2, starx[j]+2, stary[j]);
        }

        bg.setColor(Color.BLUE);

        if (i > 0){
            for (int z=0; z < i-1; z++){
                bg.drawLine(ptx.get(z), pty.get(z), ptx.get(z+1), pty.get(z+1));
            }
        }

        bg.setColor(Color.CYAN);
        bg.fillOval((int)px, (int)py, 25, 25); //planet

        bg.setColor(Color.RED);
        bg.fillRect((int)(x-5),(int)(y-5),10,10); //ship

        double fg = (5*50000)/(Math.pow(dist(x,y,px,py),2));

        double m = (y-py)/(x-px);
        double ms = Math.sqrt(Math.abs(m));
        if (m < 0) ms = -ms;

        double xchg = fg;
        double ychg = fg*ms;

        if (x > px){
            xchg = -xchg;
            ychg = -ychg;
        }

        xvel += xchg;
        yvel += ychg;

        x += xvel;
        y += yvel;

        ptx.add((int)x);
        pty.add((int)y);

        i++;
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new Gravity());
                frame.setResizable(false);
                frame.pack();

                frame.setLocationByPlatform(true);
                frame.setVisible(true);
            }
        });
    }


    public static double dist(double x1, double y1, double x2, double y2){
        double x = x2-x1;
        double y = y2-y1;
        return Math.sqrt((x*x)+(y*y));
    }
}