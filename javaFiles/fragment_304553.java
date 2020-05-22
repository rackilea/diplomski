import java.util.*;

class Product {
    private String name;
    private double cost;

    public Product (String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}

class Car extends Product {
    public Car(String name, double cost) {
        super(name, cost);
    }
}

class Truck extends Product {

    public Truck(String name, double cost) {
        super(name, cost);
    }
}

class Tool extends Product {

    public Tool(String name, double cost) {
        super(name, cost);
    }   
}



class Entry {
    private int quantity = 1;
    private double cost;

    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return cost;
    }

    public Entry(double cost) {
        this.cost = cost;
    }

    public void add (double cost) {
        quantity++;
        this.cost += cost;
    }

    @Override
    public String toString() {
        return ("Quantity = " + quantity + ", Total cost = " + cost);
    }
}


public class Inventory {

    static void takeInventory(List<Product> list) {
        Map<String, Entry> map = new HashMap<>();

        for (Product p : list) {
            Entry e = map.get(p.getName());
            if (e == null) {
                map.put(p.getName(), new Entry(p.getCost()));
            } else {
                e.add(p.getCost());
            }
        }

        for (String s : map.keySet()) {
            System.out.print(s);
            Entry e = map.get(s);
            System.out.println(" " + e);            
        }
    }

    public static void main(String [] args) {
        ArrayList<Product> list = new ArrayList<Product>();
        list.add(new Car("Jaguar", 100000));
        list.add(new Car("Neon", 17000));
        list.add(new Tool("JigSaw", 149.18));
        list.add(new Car("Jaguar", 110000));
        list.add(new Car("Neon", 17500));
        list.add(new Car("Neon", 17875.32));
        list.add(new Truck("RAM", 35700));
        list.add(new Tool("CircularSaw", 200));
        list.add(new Tool("CircularSaw", 150));
        list.add(new Tool("saw1", 200));
        list.add(new Tool("saw2", 150));

        takeInventory(list);
    }
}