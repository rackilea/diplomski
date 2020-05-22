import java.util.Collection;
import java.util.Collections;

public class Generics {
  public void foo(Collection<? extends Class<? extends Throwable>> c) { 
  }

  {
    foo(Collections.singleton(RuntimeException.class));
  }
}