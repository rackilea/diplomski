import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Average    
{
static Object lock=new Object();
static int sizeX = 200;
static int sizeY = 200;
static int maxNum = 100;
static int minNum = 1;
static boolean running = false;    
static JButton b1 = new JButton("Click me");    
static void JFrame()   
{   
     Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension dim = tk.getScreenSize();  
    JFrame f = new JFrame("Test");
    f.setSize(sizeX, sizeY);
    f.setVisible(true);
    f.setLocation((dim.width - sizeX) / 2, (dim.height - sizeY) / 2);
    f.setResizable(false);
    f.setAutoRequestFocus(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    f.add(b1);

}

public class Thr extends Thread
{       
    @Override 
    public void run()
    {
          int numsGenerated = 0;
          double ave = 0;
          synchronized(lock)
          {
              running=!running;
          }
          if (running == true)
          {
              while (true)    
              {

                  double r = Math.random() * (maxNum - minNum) + minNum; //(maxNum - minNum) + minNum
                  numsGenerated++;    
                    ave = ave + r;    
                        System.out.println("Random: " + r);   
                        synchronized(lock)
                        {
                            if (!running)
                            {
                                break;
                            }
                        }
              }                  
              synchronized(lock)
              {
                  running = false;
              }
          }                 
              System.out.println("");
              System.out.println("All: " + ave);
              System.out.println("Average: " + ave / numsGenerated);
              running = true;       
    }   
}
static Thr thread=null;
static void ActionListener()    
{  
    b1.addActionListener(new ActionListener()//ActionListener  
    {    
      public void actionPerformed(ActionEvent e)//Execute when button is pressed

      {
          Average av=new Average();
          if(thread==null)
          {
               thread=av.new Thr(); // should add in an executor
               thread.start();
          }
          else
          {
              synchronized(lock)
              {
                  running=false;
              }
          }
      }


    }); //ActionListenerEnd    
}

  public static void main(String[] args)//Main    
  {    
      JFrame();
      ActionListener();    
  }    
}