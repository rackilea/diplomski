import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

class Graph_mod extends Frame {
    Scanner input = new Scanner(System.in);  // Place scanner here ***
    private static double h = 0.0;
    private static double r = 0.0;

public static void main( String[] args ) {
    System.out.println("enter v :");
    double v = input.nextDouble();
    System.out.println("enter a :");
    double a1 = input.nextDouble();
    double a2 = a1*Math.PI/180;
    double t = v*Math.sin(a2)/9.8;
    h = Math.pow(v*Math.sin(a2), 2)/(2*9.8);
    r = Math.pow(v,2)*Math.sin(2*a2)/9.8;
    //..........................
    //..........................
}