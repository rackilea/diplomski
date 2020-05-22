import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class MyObject
{
    private long id;
    private double price;
    private String name;
    private long date;

    public MyObject(long id, double price, String name) {
    this.id = id;
    this.price = price;
    this.name = name;
    this.date = new Date().getTime();
    }

    @Override
    public String toString() {
        return "MyObject [id=" + id + ", price=" + price + ", name=" + name
                + "]";
    }

    public double getPrice() {
        return price;
    }
    public long getDate() {
        return date;
    }
}

public class MapSort {

    public static void main(String[] args) {
        Map<Long, MyObject> myMap = new LinkedHashMap<Long, MyObject>();

        myMap.put(1L, new MyObject(1, 26, "Mat"));
        myMap.put(4L, new MyObject(4, 25, "Tommy"));
        myMap.put(16L, new MyObject(16, 24, "Kate"));
        myMap.put(63L, new MyObject(63, 26, "Mary"));
        myMap.put(99L, new MyObject(99, 24, "Ronny"));

        System.out.println("Before Sorting");
        System.out.println(myMap);
        System.out.println("\nAfter Sorting");
        System.out.println(sortMap(myMap));
    }

    private static Map<Long, MyObject> sortMap(
            Map<Long, MyObject> unsortedMap) {

        List<Entry<Long, MyObject>> list = new LinkedList<Entry<Long, MyObject>>(unsortedMap.entrySet());

        Collections.sort(list,
                new Comparator<Entry<Long, MyObject>>() {

                    @Override
                    public int compare(Entry<Long, MyObject> o1, Entry<Long, MyObject> o2) {
                        int priceResult = Double.valueOf(o1.getValue().getPrice()).compareTo(Double.valueOf(o2.getValue().getPrice()));
                        if(priceResult != 0) return priceResult;
                        return Long.valueOf(o1.getValue().getDate()).compareTo(Long.valueOf(o2.getValue().getDate()));
                    }
                });

        Map<Long, MyObject> sortedMap = new LinkedHashMap<Long, MyObject>();
        for(Entry<Long, MyObject> item : list){
            sortedMap.put(item.getKey(), item.getValue());
        }
        return sortedMap;
    }
}