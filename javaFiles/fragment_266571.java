import java.util.Vector;

public class VectorAutoBox {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add(1);
        vector.add(5);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(6);
        System.out.println(vector);
        vector.remove( new Integer( 5 )); // case 1
//      vector.remove( 5 );               // case 2
        System.out.println(vector);
    }
}