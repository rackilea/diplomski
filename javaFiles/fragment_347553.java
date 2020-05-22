public class ErrorContext {
    public IllegalStateException fatalISE(String message) {
        String context = "gather lots of information about the context of the error";
        return new IllegalStateException(context +": " + message);
    }
}

public class A {
    public MyObject myMethod() {
        if (allIsGood()) {
            return new MyObject();
        }
        throw ErrorContext.fatalISE("all is not good");
    }
}