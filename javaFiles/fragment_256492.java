package main;

import java.io.FileInputStream;
import java.io.IOException;

public class Exam {
    public static void main(String[] args) throws Throwable {

        Depot depot = (Depot)Depot.loadFromStream(null, Depot.class);
        System.out.println(depot);
        Ship ship = (Ship)Ship.loadFromStream(null, Ship.class);
        System.out.println(ship);

    }
}

class Depot extends Item2
{
}

class Ship extends Item2
{
}

abstract class Item2
{
    public static Object loadFromStream(FileInputStream oos, Class c) throws IOException, Throwable
    {   
        return c.newInstance();
    }
}