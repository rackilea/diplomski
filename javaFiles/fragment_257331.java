package Program1;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Scanner;

public class Demo extends Applet{
    static int i=0;

    public static void test(){
        i=50;
        System.out.println("This is my static method");
    }

    public Demo(){
        test();
    }


    public void paint (Graphics g)  {

        g.drawOval (60, 20, i, i);
    }

}