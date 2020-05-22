public class MyLogger extends Logger
{

public MyLogger(String name, String resourceBundleName)
    {
        super(name, resourceBundleName);    
    }

public void error(String msg)
    {
        super.log(MyErrorLevel.ERROR, msg);
    }
public void error(String msg)
    {
        super.log(MyErrorLevel.SERIOUS_ERROR, msg);
    }
}