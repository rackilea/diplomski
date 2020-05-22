public class Example {
    public static void main(String[] args) throws Exception {
        Field field = Fail.class.getDeclaredField("number");
        field.set(null, 42); // Fail class isn't initialized at this point
    }
}

class Fail {
    static int number;
    static {
        boolean val = true;
        if (val)
            throw new RuntimeException(); // causes initialization to end with an exception
    }
}