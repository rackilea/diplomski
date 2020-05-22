public class MyObject {
    private static Map<Integer, Integer> counters = new HashMap<>();

    private int size;

    public MyObject(int size) {
        this.size = size;
        Integer sizeCounter = counters.get(size);
        if (sizeCounter == null) {
            sizeCounter = 0;
        }
        counters.put(size, ++sizeCounter);
    }

    public static Integer getSizeCounter(Integer size) {
        Integer sizeCounter = counters.get(size);
        if (sizeCounter == null) {
            sizeCounter = 0;
        }
        return sizeCounter;
    }
}

public class Test {
    public static void main(String[] args) {
        MyObject mo11 = new MyObject(1);
        MyObject mo12 = new MyObject(1);
        MyObject mo13 = new MyObject(1);
        MyObject mo2 = new MyObject(2);
        MyObject mo3 = new MyObject(3);
        System.out.println(MyObject.getSizeCounter(1)); // prints 3
        System.out.println(MyObject.getSizeCounter(2)); // prints 1
        System.out.println(MyObject.getSizeCounter(3)); // prints 1
        System.out.println(MyObject.getSizeCounter(4)); // prints 0
    }
}