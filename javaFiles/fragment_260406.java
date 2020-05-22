public class SomeClass
{
    public static int someFunction(int a) {
        return a;
    }

    public static void main(String[] args) {    
        someFunction(3); // "error" - ignoring return type
        int unused = someFunction(3); // "success"
    }
}