public class Store {
String str1;
String str2;

public Store(String string1, String string2) {
    str1 = string1;
    str2 = string2;
}

public static void main(String[] args) {

    Store[] s = new Store[10]; // size
    for (int i = 0; i < s.length; i++) {
        s[i] = new Store("A", "B");
        System.out.println(s[i].str1);
        System.out.println(s[i].str2);

    }

}
}