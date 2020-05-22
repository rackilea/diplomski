import java.util.*;

public class StockData {

    private static class Item {
        Item(String n, double p, int q, String f) {
            name = n;
            price = p;
            quantity = q;
            filename = f;
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

        public String getFilename() {
            return filename;
        }

        // instance variables 
        private final String name;
        private final double price;
        private int quantity;
        private String filename;
    }

    public final static Map<String, Item> stock = new HashMap();

    static {
        // if you want to have extra stock items, put them in here
        // use the same style - keys should be Strings
        stock.put("00", new Item("Bath towel", 5.50, 10, "images/crazyEmoji.jpg"));
        stock.put("11", new Item("Plebney light", 20.00, 5, "images/sadEmoji.png"));
        stock.put("22", new Item("Gorilla suit", 30.00, 7, "images/scaredEmoji.jpg"));
        stock.put("33", new Item("Whizz games console", 50.00, 8, "images/winkEmoji.png"));
        stock.put("44", new Item("Oven", 200.00, 4, "images/zippedEmoji.jpg"));
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

    public static double getPrice(String key) {
        Item item = stock.get(key);
        if (item == null) {
            return -1.0; // negative price means no such item
        } else {
            return item.getPrice();
        }
    }

    public static int getQuantity(String key) {
        Item item = stock.get(key);
        if (item == null) {
            return -1; // negative quantity means no such item
        } else {
            return item.getQuantity();
        }
    }
    public static String getFilename(String key) {
        Item item = stock.get(key);
        if (item == null) {
            return null; // null means no such item
        } else {
            return item.getFilename();
        }
    }

    public static void update(String key, int extra) {
        Item item = stock.get(key);
        if (item != null) {
            item.quantity += extra;
        }
    }


}