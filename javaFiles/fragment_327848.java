import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class myPanel extends Canvas implements Runnable {

//FIELDS
private static final long serialVersionUID = 1L;
public static int WIDTH = 1024;
public static int HEIGHT = WIDTH / 16 * 9;
private JFrame frame;
private boolean running;
private Thread t1;


public myPanel(){
    Dimension size = new Dimension(WIDTH, HEIGHT);

    setPreferredSize(size);

    frame = new JFrame();
}


public synchronized void start (){
    running = true;
    t1 = new Thread (this);
    t1.start(); // calls run()
}


//Main runnable

public void run(){
    while (running){   
       update();
       draw();
    }
}


public void update(){

}


public void draw(){
   BufferStrategy bs = getBufferStrategy();
   if (bs== null){
   createBufferStrategy(3);
   return;
   }

   Graphics g = bs.getDrawGraphics();
   g.setColor(Color.BLACK);
   g.fillOval(0, 0, 20, 20);
   g.dispose();
   bs.show();
}

public static void main(String[] args){
    myPanel myPanel = new myPanel();

     myPanel.frame.setResizable(false);
     myPanel.frame.setTitle("My frame");
     myPanel.frame.add(myPanel);
     myPanel.frame.pack();
     myPanel.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     myPanel.frame.setLocationRelativeTo(null);
     myPanel.frame.setVisible(true);

     myPanel.start();
}
}