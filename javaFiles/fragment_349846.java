class Calculator
{
  // Well, this would probably better be an enum, but whatever.
  public char operator=' ';
  public float lastNum;

  public void calc()
  {
    try
    {
      double currNum=Double.parseDouble(numfield.getText());
      if (operator==' ')
        lastNum=currNum;
      else if (operator=='+')
        lastNum+=currNum;
      else if (operator=='-')
        lastNum-=currNum;
      else if (operator=='*')
        lastNum*=currNum;
      else if (operator=='/')
        lastNum/=currNum;
    }
    catch (NumberFormatException panic)
    {
      ... whatever error handling ...
    }
  }
}
class OperatorListener implements ActionListener
{
   Calculator calc;
   public OpeatorListener(Calculator calc)
   {
     this.calc=calc;
   }
   public abstract void actionPerformed(ActionEvent e);
}
class PlusListener extends OperatorListener
{
  public void actionPeformed(ActionEvent e)
  {
    calc.calc();
    calc.operator='+';
  }
}
class MinusListener extends OperatorListener
{
  public void actionPerformed(ActionEvent e)
  {
    calc.calc();
    calc.operator='-';
  }
}
class EqualListener extends OperatorListener
{
  public void actionPerformed(ActionEvent e)
  {
    calc.calc();
  }
}