import java.util.List;

interface MyInterface<T extends List<Integer>> {
    T getResult();

    void useResult(T inResult);
}

class SomeOtherClass {
    static <T extends List<Integer>> void moveObject(MyInterface<T> inObj) {
        T result = inObj.getResult();
        inObj.useResult(result);
    }
}