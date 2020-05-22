import java.util.function.Consumer;
import java.util.function.Function;

class A {
    @Override public String toString(){ return "A";}
    public String foo(){ return "foo";}
}

class B extends A {
    @Override public String toString(){ return "B";}
    public String bar(){ return "bar";}
}

class C extends B { }

public class Main {

    public static void main(String[] args) {
        Function<A,String> funA = a -> a.foo();
        Function<B,String> funB = b -> b.bar();
        Function<C,String> funC = c -> c.bar();
        Consumer<B> ignoreArgument = b -> {
            System.err.println("  Consumer called");
        };

        B b = new B();
        System.err.println("* voidTest *");
        voidTest(b);
        System.err.println("------------");
        System.err.println("* returnTest *"); 
        returnTest(b);
        System.err.println("returnTest without using result did not throw");
        System.err.println("------------");
        try {
            System.err.println("Returned " + returnTest(b).toString());
            System.err.println("returnTest: invoking method on result did not throw");
        }
        catch(Exception ex) {
            System.err.println("returnTest: invoking method on result threw");
            ex.printStackTrace();
        }
        System.err.println("------------");
        B b2 = null;
        try {
            b2 = returnTest(b);
            System.err.println("returnTest: assigning result to a B variable did not throw");
        }
        catch(Exception ex) {
            System.err.println("returnTest: assigning result to a B variable threw");
            ex.printStackTrace();
        }
        System.err.println("------------");
        System.err.println("* functionTest funA *");
        functionTest(b, funA);
        System.err.println("------------");
        System.err.println("* functionTest funB * ");
        functionTest(b, funB);
        System.err.println("------------");
        System.err.println("* consumerTest *");
        consumerTest(b, ignoreArgument);
        // The following won't work because C is not B or a superclass of B
        // Compiler error functionTest(T, Function<? super T,String>) is not applicable for the arguments (B, Function<C,String>)
        // functionTest(b, funC); 
    }

    private static <T extends A> void voidTest(T t){
        System.err.println("  Before: " + t.toString());
        t = (T)new A(); // warning Type safety: Unchecked cast from A to T
        System.err.println("  After: " + t.toString());
    }

    private static <T extends A> T returnTest(T t){
        System.err.println("  Before: " + t.toString());
        t = (T)new A();
        System.err.println("  After: " + t.toString());
        return t;
    }

    private static <T extends A> void functionTest(T t, Function<? super T,String> fun) {
        System.err.println("  fun Before: " + fun.apply(t));
        t = (T)new A();
        try {
            System.err.println("  fun After: " + fun.apply(t));
        }
        catch(Exception ex) {
            System.err.println("  fun After: threw");
            ex.printStackTrace();
        }
    }

    private static <T extends A> void consumerTest(T t, Consumer<? super T> c) {
        System.err.print("  Before: ");
        c.accept(t);
        t = (T)new A();
        try {
            System.err.println("  After: ");
            c.accept(t);
            System.err.println("    c.accept(t) After: worked");
        }
        catch(Exception ex) {
            System.err.println("    c.accept(t) After: threw");
            ex.printStackTrace();
        }
    }
}