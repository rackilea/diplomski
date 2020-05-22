import java.util.function.*;

    public class MethodCalls {

       public static void main(String[] args) {
          new MethodCalls().start();
       }

       public void start() {
          Map<Integer, Function<Integer, Integer>> callTable = new HashMap<>();
          callTable.put(1, a -> prod(a));
          callTable.put(2, a -> sub(a));
          Random r = new Random();
          r.ints(10, 1, 3).forEach(b -> System.out.println("The answer is "
                + callTable.get(b).apply(r.nextInt(20) + 20) + "\n"));
       }

       public int prod(int v) {
          System.out.println("Multiplying " + v + " by " + 40);
          return v * 40;
       }

       public int sub(int v) {
          System.out.println("Subtracting " + 30 + " from " + v);
          return v - 30;
       }
    }