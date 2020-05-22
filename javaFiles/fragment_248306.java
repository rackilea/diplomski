class NullArgumentException extends IllegalArgumentException {

    public NullArgumentException() {
        super("arg cannot be null");
    }
}

public class Test {

    public static void main(String[] args) {

        try {
            foo(null);
        } catch(IllegalArgumentException e) {
            // or System.out.println(e.getMessage())
            e.printStackTrace();
        }
    }

    public static void foo(Integer i) throws IllegalArgumentException {
        if(i == null) throw new NullArgumentException();
    }
}