public class fast {
public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    long x = 1000000000;
    String s = "abc";
    boolean bool = true;
    for (int j = 0; j < 50; ++j) {
        for (int i = 0; i < x; ++i) {
            char a = s.charAt(2);
            // try different things, like using arrays instead of strings, etc.
        }
    }

    long endTime = System.currentTimeMillis();
    System.out.println("took " + (endTime-startTime) + " ms);
}
}