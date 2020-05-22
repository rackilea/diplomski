import java.util.concurrent.atomic.AtomicInteger;

 public class UniqueThreadIdGenerator {

     private static final AtomicInteger uniqueId = new AtomicInteger(0);

     private static final ThreadLocal < Integer > uniqueNum = 
         new ThreadLocal < Integer > () {
             @Override protected Integer initialValue() {
                 return uniqueId.getAndIncrement();
         }
     };

     public static int getCurrentThreadId() {
         return uniqueId.get();
     }
 } // UniqueThreadIdGenerator