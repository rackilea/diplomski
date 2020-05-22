public class FancyClass<T> {
    T myVal;
    public FancyClass(T val) {
        myVal = val;
    }
}

FancyClass<Integer> myFancyClass = new FancyClass<>(1);