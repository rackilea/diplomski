public abstract interface MathExpressionParser {

      public Calculation parse(String expression);

}

public abstract interface Calc<T extends Number> { 

   public abstract T add(T num1, T num2);
   public abstract T substract(T num1, T num2);
   public abstract T multiple(T num1, T num2);
   public abstract T divide(T num1, T num2);

}