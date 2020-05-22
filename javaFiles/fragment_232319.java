public class App {
    public static int origValue = 5;

    public static void main(String[] args) {
        System.out.println(factorial(origValue));
    }

    private static int factorial(int value) {
        doMinuses(origValue-value);
        System.out.println("Entered factorial("+value+")");
        if(value == 1) {
        doMinuses(origValue-value);
        System.out.println("Returning 1");
            return 1;
        }

        doMinuses(origValue-value);
        System.out.println("Start countin factorial("+(value-1)+")*"+value);
        int factorialResult = factorial(value - 1) * value;
        doMinuses(origValue-value);
        System.out.println("Returning result for factorial("+(value-1)+")*"+value + " = " + factorialResult);
        return factorialResult;
    }

    private static void doMinuses(int count){
        for (int i = 0; i < count; i++) {
            System.out.print('-');
        }        
    }
}