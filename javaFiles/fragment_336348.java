public class Plus implements Operator
{   
  public double calculate(double firstNumber,double secondNumber)
  {
     return firstNumber + secondNumber;
  }
  public char getSign()
  {
     return '+';
  }
}