import static com.package.ABC.method;

public class GHI {
    public static void main(String args[]) {
        method(); // calling the static ABC.method()
        DEF ABC = new DEF();
        method(); // calling the static ABC.method
        ABC.method(); //calling the instance method()
    }
}