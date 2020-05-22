import java.util.Set;
import java.util.TreeSet;

public class MyMates {

private static String[] name1 = null;
private static String[] name2 = null;
private static String[] name3 = null;
private static Set<String> names;

public MyMates() {
    methodASet();
    names = new TreeSet<String>();
}

public static void methodASet() {

    name1 = new String[]{"Amy", "Jose", "Jeremy", "Alice", "Patrick"};
    name2 = new String[]{"Alan", "Amy", "Jeremy", "Helen", "Alexi"};
    name3 = new String[]{"Adel", "Aaron", "Amy", "James", "Alice"};
}

public static void methodB() {

    for (int i = 0; i < name1.length; i++) {
        names.add(name1[i]);
    }
    System.out.println(names);

    for (int i = 0; i < name2.length; i++) {
        names.add(name2[i]);
    }
    System.out.println(names);

    for (int i = 0; i < name3.length; i++) {
        names.add(name3[i]);
    }
    System.out.println(names);
}

public static void main(String[] args) {
    MyMates polop = new MyMates();
    MyMates.methodB();
}
}