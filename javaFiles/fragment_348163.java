public class testLambda {
    Map<String, Runnable> printNumber = new HashMap<>();
    static {
        printNumber.put("One", () -> printStringOne());
        printNumber.put("Two", () -> printStringTwo());
        printNumber.put("Three", () -> printStringThree());
    }

    testLambda(String num){
        printNumber.get(num).run();  // Add some checking here for robustness
    }