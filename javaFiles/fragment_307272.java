public interface Result {  
    public boolean isOk();
    public String getMessage();
}

// We make it genric so that we can use it to validate
// any type of Object that we want.
public interface Validator<T> {
    public Result validate(T value);
}