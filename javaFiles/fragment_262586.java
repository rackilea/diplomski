@FunctionalInterface
interface Pro<T> {
    void callee(T t);
}

public class Test {    
    public static <T> void fun(Pro<T> obj){}

    public static void main(String[] args) {
        fun((Integer t) -> {});
    }
}