import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FooShell
{
  int runningTotal;

  FooShell()
  {
    runningTotal = 0;
  }

  public static void main(String[] args)
  {

    FooShell fooShell = new FooShell();
    InputStreamReader isReader = new InputStreamReader(System.in);
    BufferedReader bufReader = new BufferedReader(isReader);
    while (true)
    {
      try
      {
        String inputStr = bufReader.readLine();
        if (inputStr == null)
        {
          break;
        }
        int currentNumber = Integer
            .parseInt(inputStr.substring(inputStr.lastIndexOf(" ") + 1));
        fooShell.runningTotal += currentNumber;
        System.out.println(currentNumber);
      }
      catch (Exception e)
      {
        System.err.println("Error " + e);
      }
    }
  }
}