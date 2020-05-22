import java.io.InputStream;
import java.io.PrintStream;
import java.util.concurrent.Callable;


public interface MyCallable<V> extends Callable<V> {
  void setStdIn(InputStream in);
  void setStdOut(PrintStream out);  
}