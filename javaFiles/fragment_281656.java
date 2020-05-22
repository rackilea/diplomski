Collections.sort(fruits);

public class Fruit implements Comparable {

    public int compareTo(Object o) {            
        Fruit f = (Fruit) o;
        return this.getName().compareTo(f.getName());
    }

}