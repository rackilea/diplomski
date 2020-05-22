package testMatlabInterface;

public class TestFunction
{
  private double value;

  public TestFunction()
  {
      value = 0;
  }

  public double Add(double v)
  {
      value += v;
      return value;
  }
}