public class Test {
    static {
        if (true) {
            throw new RuntimeException("Bang!");
        }
    }

    public static void main(String[] args) {
    }    
}