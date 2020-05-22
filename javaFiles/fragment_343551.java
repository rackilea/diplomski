abstract class Abstract {
   static Abstract createInstance(int size) {
       return size < 10 ? new SmallImplementation() : new LargeImplementation();
   }

   public abstract String getDescription();
}

class SmallImplementation extends Abstract {
   @Override public String getDescription() {
       return "I'm an implementation for small sizes";
   }
}

class LargeImplementation extends Abstract {
   @Override public String getDescription() {
       return "I'm an implementation for large sizes";
   }
}

public class Test {
   public static void main(String[] args) throws InterruptedException {
       Abstract small = Abstract.createInstance(1);
       Abstract large = Abstract.createInstance(100);
       System.out.println(small.getDescription());
       System.out.println(large.getDescription());
   }
}