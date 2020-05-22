package stack;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;

public class TheColorInfo {
    static PointerInfo pointer;
    static Point point;
    static Robot robot;

    static Color color;

    public static void main(String[] args) {
        try{
            robot = new Robot();

            while(true){
                pointer = MouseInfo.getPointerInfo();
                point = pointer.getLocation();
                if(point.getX() == 0 && point.getY() == 0){
                    break; // stop the program when you go to (0,0)
                }else{
                    color = robot.getPixelColor((int)point.getX(),(int)point.getY());
                    System.out.println("Color at: " + point.getX() + "," + point.getY() + " is: " + color);
                }
            }
        }catch(Exception e){

        }
    }
}