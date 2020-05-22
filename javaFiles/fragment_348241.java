import java.lang.Exception;

// Don't forget to serialize your custom exception class (this class).
public class SomethingException extends Exception{
    public SomethingException(String il){
         super(il);
  }
}