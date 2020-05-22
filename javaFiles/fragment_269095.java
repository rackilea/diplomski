public interface I1 {
   String NAME = "codemonkeyism";
}

public interface I2 {
   String NAME = "stephan";
}

public class C implements I1, I2 {
   public static void main(String[] args) {
      System.out.println(NAME);
   }
}