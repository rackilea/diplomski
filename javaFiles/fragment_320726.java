package Shift;

import java.util.*;

public class Shift {

    public static void main(String[] args) {

        Shift c = new Shift();

        Circle c1 = c.new Circle(4,6,4); 
        Circle c2 = c.new Circle(4,5,4); 
        Circle c3 = c.new Circle(5,4,4);
        Circle c4 = c.new Circle(5,4,3);


        Circle[] a = {c1, c2, c3, c4};

        Arrays.sort(a); 
        System.out.print(a[0]);
    }



public class Point{

    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x; this.y = y; 
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}



public class Circle extends Point implements Comparable<Circle>{

    private double radius;
    private Point point;

    public Circle(int x, int y, double radius) {
            super(x, y);
            this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }

    public Point getPoint(){
        return this.point;
    }

    public int area(){
        return (int) (Math.PI*radius*radius);
    }

    public int compareTo(Circle other){
        if(this.area()>other.area())
            return 1;


        if(this.area()<other.area())
            return -1;
        else if(this.getX()>other.getX())
                return 1;


        if (this.getX()<other.getX())
                return -1;
        else if(this.getY()<other.getY())
            return -1;
        else
            return 1;
    }

    @Override
    public String toString(){
        return "Circle of radius " + radius; 
    }
}


}