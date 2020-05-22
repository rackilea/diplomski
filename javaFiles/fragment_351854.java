import java.util.ArrayList;
import java.util.Collections;

public class InnerObject implements Comparable<InnerObject> {
    Integer index;
    String  name;

    public InnerObject(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public int compareTo(InnerObject other) {
        return index.compareTo(other.index);
    }

    @Override
    public String toString() {
        return "{" + index + "," + name + "}";
    }

    public static void main(String[] args) {
        ArrayList<InnerObject> list = new ArrayList<InnerObject>();
        list.add(new InnerObject(666, "devil"));
        list.add(new InnerObject(1, "one"));
        list.add(new InnerObject(10, "ten"));

        System.out.println("list before order: " + list);

        Collections.sort(list);

        System.out.println("list after order: " + list);

    }   
}