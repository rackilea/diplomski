import java.util.concurrent.atomic.*;
public class A {
   private static final AtomicBoolean status = new AtomicBoolean(true);
   public boolean flipStatusToTrue() { // return true if value has been flipped
       return status.compareAndSet(false, true);
   }
   public boolean flipStatusToFalse() { // return true if value has been flipped
       return status.compareAndSet(true, false);
   }
}