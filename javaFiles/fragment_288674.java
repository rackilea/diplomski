import java.util.ArrayList;
public class ListTableClass {
    private String name;
    private int age;

public ListTableClass(String name, int age) {
    super();
    this.name = name;
    this.age = age;
}

public static void main(String[] args) {
    ArrayList<ListTableClass> ltc = new ArrayList<ListTableClass>();// has duplicate
    ListTableClass obj0 = new ListTableClass("A", 0);
    ListTableClass obj1 = new ListTableClass("B", 1);
    ListTableClass obj2 = new ListTableClass("C", 2);
    ListTableClass obj3 = new ListTableClass("A", 0);
    ltc.add(obj0);
    ltc.add(obj1);
    ltc.add(obj2);
    ltc.add(obj3);
    ArrayList<ListTableClass> ltc2 = new ArrayList<ListTableClass>();// unique
    for (ListTableClass element : ltc) {
        if (!ltc2.contains(element)) {
            System.out.println(element);
            ltc2.add(element);
        }
    }
}
}