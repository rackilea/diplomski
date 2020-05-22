public class StackManager {

    private static StackManager ourInstance = new StackManager();
    public Stack myStack = new Stack();

    public static StackManager getInstance() {
         return ourInstance;
    }

    private StackManager() {
    }
}