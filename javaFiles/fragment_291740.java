public class MyErrorLevel extends Level
{

public static MyErrorLevel ERROR = new MyErrorLevel ("ERROR", 950);
public static MyErrorLevel SERIOUS_ERROR = new MyErrorLevel("SERIOUS_ERROR", 980);
//...and so on...

private MyErrorLevel(String name, int value)
    {
        super (name, value);
    }

}