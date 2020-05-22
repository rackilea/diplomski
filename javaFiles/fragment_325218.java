import java.util.ArrayDeque;
import java.util.Deque;

public class ThingPool {

    public static class Thing {

    }
    // start with a big stack of objects
    Deque<Thing> stack = new ArrayDeque<Thing>(1000);
    /**
     * Gets a new instance. If one exists in the stack use that,
     * otherwise create a new one.
     * @return
     */
    public Thing getThing() {
        if(stack.isEmpty())
            return new Thing();
        return stack.pop();
    }
    /**
     * Does not actually delete it, just stores it for later use
     * @param thing
     */
    public void deleteThing(Thing thing) {
        stack.push(thing);
    }
    /**
     * You may need to clear your pool at some point
     * if you have a great many objects in it 
     */
    public void clear() {
        stack.clear();
    }
}