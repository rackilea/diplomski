public class MyArray {
    public final static String [] myArray = { "one", "two", "three" } ;
}



public class MyMain {
    public static void main(String[] args) {
        for (String s : MyArray.myArray ) {
            System.out.println( s );
        }
    }
}