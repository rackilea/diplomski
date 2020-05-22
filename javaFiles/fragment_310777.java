public class Snippet<T> {

    private final ResponseHandler<? extends T> var;

    public Snippet(ResponseHandler<? extends T> var) {
        super();
        this.var = var;
    }


    public <U> U execute(ResponseHandler<? extends U> responseHandler) {
        // This class is generic wrt to T, but this method is generice wrt to U.
        // You cannot store the variable passed in here in a data member
        // because the type cannot possible be known at compile time, as it
        // depends on client code calling this method.
        return null;
    }
}