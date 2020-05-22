import java.util.LinkedList;
import java.util.List;

class A {
    public static void main(String[] args) {
        int count = 0;
        try {
            List<Thread> threads = new LinkedList<>();
            while (true) {
                threads.add(new Thread());
                if (++count % 10000 == 0)
                    System.out.println(count);
            }
        } catch (Error e) {
            System.out.println("Got " + e + " after " + count + " threads");
        }
    }
}