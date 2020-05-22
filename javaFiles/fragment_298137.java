package sof_6406645;

import javax.swing.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Checkers {

    public static void main(String[] args) {
        JFrame frame = new JFrame("2D Game");

        frame.add(new Board());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,326);
        frame.setVisible(true);
    }
    public static class Board extends JPanel implements ActionListener {

        final Image img;
        Point p;
        final boolean[] dynamics = new boolean[4];

        public Board() {
            addKeyListener(new AL());
            setFocusable(true);
            ImageIcon i = new ImageIcon("dude.png");
            img = i.getImage();
            p = new Point(0,0);
            Timer timer = new Timer(5, this);
            timer.start();
        }
        public void actionPerformed(ActionEvent e){
            moveImage();
        }
        public void moveImage (){
            int dx = 0;
            int dy = 0;
            if(dynamics[0]) dx = -2; 
            if(dynamics[1]) dy = -2; 
            if(dynamics[2]) dx = 2; 
            if(dynamics[3]) dy = 2; 
            p.move((int)p.getX() + dx, (int)p.getY() + dy);
            repaint();
        }

        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(img, (int)p.getX(), (int)p.getY(), null);
        }

        private class AL extends KeyAdapter{
            public void keyReleased(KeyEvent e){
                updateDynamics(e, false);
            }
            public void keyPressed (KeyEvent e){
                updateDynamics(e, true);
            }
        }
        final void updateDynamics(KeyEvent e, boolean v) {
            int i = e.getKeyCode() - KeyEvent.VK_LEFT;
            dynamics[i] = v;
        }
    }
}