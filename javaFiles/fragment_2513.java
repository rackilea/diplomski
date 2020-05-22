//Non-Thread Safe Callable implementation
public class MyCallable implements Callable<String> {

    private int i;

    @Override
    public String call() throws Exception {
         i++; //RACE CONDITION
         System.out.println(i);
         return String.valueOf(i);
    }
}