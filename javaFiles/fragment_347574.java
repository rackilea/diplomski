import java.util.function.Function;

public class FunctionDemo {

    // we will pass a reference to this method
    public static Integer square(Integer x) {
        return x * x;
    }

    // this method accepts the function as an argument and applies it to the input: 5
    public static Integer doSomething(Function<Integer, Integer> func) {
        return func.apply(5);
    }

    public static void main(String[] args) {
        // and here's how to use it
        System.out.println(doSomething(FunctionDemo::square)); // prints 25
    }   
}