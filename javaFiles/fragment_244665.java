public class Context {
   private Strategy strategy;
   public Context(Strategy strategy){
      this.strategy = strategy;
   }
   public int executeStrategy(int num1, int num2){
      return strategy.doOperation(num1, num2);
   }
}
public class OperationMultiply implements Strategy{
   @Override
   public int doOperation(int num1, int num2) {
      return num1 * num2;
   }
}