package com.mumpitz.simplexmltest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

// the base class
@Element
class Thing {

    static int count=0;

    Thing() {
        this.id = ++count;
    }

    @Attribute
    protected int id;

    public int getId() {
        return id;
    }
}

// first derived class
@Element
class Car extends Thing {
    @Attribute
    private String name;

    Car(@Attribute(name="name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "ID: " + id + " Car: " + name;
    }
}

// second derived class
@Element
class House extends Thing {
    @Attribute
    private int price;

    House(@Attribute(name="price") int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
    @Override
    public String toString() {
        return "ID: " + id + " House: " + price;
    }
}


// a class with a list of base class instances
@Root(name="ListOfThings")
public class Example4 {

    // specify the derived classes used in the list
    @ElementListUnion({
        @ElementList(entry="house", inline=true, type=House.class),
        @ElementList(entry="car", inline=true, type=Car.class)
    })
    private ArrayList<Thing> list = new ArrayList<Thing>();

    public void add(Thing t) {
        list.add(t);
    }

    public List<Thing> getProperties() {
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Example4 contains " + list.size() + " elements:\n");
        for (Thing t : list) {
            sb.append(" " + t.toString() + "\n");
        }
        return sb.toString();
    }


    //////////////////////////////////
    // test code
    //////////////////////////////////
    static String msg;
    static Example4 res;

    static public String getMessage() {
        String m = msg;
        msg = null;
        return m;
    }

    static private Example4 createDummy() {
        Example4 d = new Example4();
        d.add(new Car("Mercedes"));
        d.add(new House(34000000));
        d.add(new Car("VW"));
        d.add(new House(230000));
        return d;
    }

    //////////////////////////////////
    // serialize / deserialize
    //////////////////////////////////
    static public boolean write(String path) {

        Serializer serializer = new Persister();
        File result = new File(path);
        Example4 example = Example4.createDummy();

        try {
            serializer.write(example, result);
        } catch (Exception e) {
            e.printStackTrace();
            msg = e.getMessage();
            return false;
        }
        return true;
    }

    static public boolean read(String path) {
        Serializer serializer = new Persister();
        File source = new File(path);

        try {
            res = serializer.read(Example4.class, source);
        } catch (Exception e) {
            e.printStackTrace();
            msg = e.getMessage();
            return false;
        }
        return true;
    }

    public static Object getResult() {
        return res;
    }
}