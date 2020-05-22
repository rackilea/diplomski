public RPNCalculation implements MathExpressionParser {

      public Calculation parse(String expression) {

            // do to parse 
       }

}


public SimpleCalc implements Calc<Number> {

    public Number add(Number num1,Number num2) {

         if(num1 == null || num2 == null) {

            throw new InvalidArgumentExpression("Method Calc.add operate only on non null valuers.");
         }

      return Double.parse(num1.doubleValue() + num2.doubleValue());

    }

}