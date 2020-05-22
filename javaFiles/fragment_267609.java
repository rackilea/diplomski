public interface Operators {
    int getCode();
}

public enum BooleanOperators implements Operators {

   private int code;

   AND(1), OR(2), NOT(3), XOR(4)

   private BooleanOperators(int code) {
       this.code = code;
   }

   public int getCode() {
       return this.code;
   }
}