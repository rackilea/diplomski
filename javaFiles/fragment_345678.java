import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

private int rate;

public static void main(String[] args) {
    Demo demo =  new Demo();
    demo.work();

}

private void work()
{
    rate = 20;
    System.out.println("Would you like to use default tax?");
    if (!getInput().equalsIgnoreCase("yes"))
    {
        System.out.println("Please set the new rate");
        rate = Integer.parseInt(getInput());
    }
    System.out.println("the rate is "+rate);
}

private String getInput()
{
    String result =  null;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try {
        result = reader.readLine();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return result;
}

}