// I the Input type
// R the result type
public interface Fn<I,R> {

  R apply (I input);
}