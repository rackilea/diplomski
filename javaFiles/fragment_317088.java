import java.util.HashMap;
import java.util.Map;

public aspect ShapeHolderAspect {
    private Map<Integer, Shape> map = new HashMap<Integer, Shape>();
    private int count = 0;

    after(Shape shape): execution(Shape+.new(..)) && this(shape) {
        System.out.println(thisJoinPointStaticPart);
        map.put(++count, shape);
    }

    after() : execution(* Application.main(..)) {
        System.out.println("\nList of shapes:");
        for (int key : map.keySet())
            System.out.println("  " + key + " -> " + map.get(key));
    }
}