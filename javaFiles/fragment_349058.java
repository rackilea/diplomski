public class EscapingThis {

    public final CompletableFuture<BigDecimal> myExpensiveVal
                = CompletableFuture.supplyAsync(() -> calculateExpensiveMethod(this));
    final int fourtyTwo;

    public EscapingThis() {
        System.out.println(Thread.currentThread()+" starts creating "+this);
        try {
            myExpensiveVal.get();
        } catch (InterruptedException|ExecutionException ex) {
            Logger.getLogger("EscapingThis").log(Level.SEVERE, null, ex);
        }
        System.out.println("still incomplete");
        fourtyTwo=42;
        System.out.println("leaving constructor");
    }

    static BigDecimal calculateExpensiveMethod(EscapingThis instance) {
        System.out.println(Thread.currentThread()
                                 +" says: hello incomplete instance "+instance);
        System.out.println("fourtyTwo = "+instance.fourtyTwo);
        return BigDecimal.ONE;
    }
    public static void main(String... arg) {
        new EscapingThis();
    }
}