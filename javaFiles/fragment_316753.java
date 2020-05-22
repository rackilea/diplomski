import java.lang.reflect.Array;

public class OuterClass<T,P> {
    public InnerClass<T, P>[] array; //field

    @SuppressWarnings("unchecked")
    public OuterClass() { //constructor
        this.array = (InnerClass<T,P>[]) Array.newInstance(InnerClass.class, 30);
    }

    static class InnerClass<T, P> { //definition of my static nested class
    }

    public static void main(String[] args) {
        OuterClass<Integer, Integer> outerClass = new OuterClass<>();
        InnerClass<Integer, Integer> innerClass = new InnerClass<>();
        outerClass.array[1] = innerClass;
        System.out.println(outerClass.array[1]);
    }
}