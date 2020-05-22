package stockdata;

import java.util.HashMap;
import java.util.Map;

public class StockData {

public static class Item {

    Item(String n, double p, int q) {
        name = n;
        price = p;
        quantity = q;
    }

    // get methods
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // instance variables
    private final String name;
    private final double price;
    private int quantity;
}

// with a Map you use put to insert a key, value pair
// and get(key) to retrieve the value associated with a key
// You don't need to understand how this works!
private final static Map<String, Item> stock = new HashMap<>();

static {
    // if you want to have extra stock items, put them in here
    // use the same style - keys should be Strings
    stock.put("00", new Item("Bath towel", 5.50, 10));
    stock.put("11", new Item("Plebney light", 20.00, 5));
    stock.put("22", new Item("Gorilla suit", 30.00, 7));
    stock.put("33", new Item("Whizz games console", 50.00, 8));
    stock.put("44", new Item("Oven", 200.00, 4));
}

public static Map<String, Item> getStock() {
    return stock;
}

public static String getName(String key) {
    Item item = stock.get(key);
    if (item == null) {
        return null; // null means no such item
    } else {
        return item.getName();
    }
}
}