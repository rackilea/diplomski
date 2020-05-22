import java.util.*;
import java.awt.Rectangle;

public class test {
    public static void main(String args[]) {
        List<Rectangle> list = new ArrayList<Rectangle>();
        /* Evil hack */
        List lst = (List)list;

        /* Works */
        lst.add("Test");

        /* Works, and prints "Test" */
        for(Object o: lst) {
            System.err.println(o);
        }

        /* Dies horribly due to implicitly casting "Test" to a Rectangle */
        for(Rectangle r: list) {
            System.err.println(r);
        }
    }
}