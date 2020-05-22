import com.google.gson.Gson;

public class GsonFoo
{
  public static void main(String[] args)
  {
    BarRun runRunRun = new BarRun();
    runRunRun.name = "Whiskey";
    runRunRun.state = 42;

    String json = new Gson().toJson(runRunRun);
    System.out.println(json);
    // output: {"name":"Whiskey","state":42}

    BarRun runCopy = new Gson().fromJson(json, BarRun.class);
    System.out.println(runCopy.name); // Whiskey
    System.out.println(runCopy.state); // 42
  }
}


class BarRun implements Runnable
{
  String name;
  int state;

  @Override
  public void run()
  {
    // do something useful
  }
}