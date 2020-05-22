public interface Transmission
{
    public void onBroadcastReceived(String key, String value);
}

public class Events     {
    protected static Events instance;

    public static Events getInstance()
    {
        if(instance == null)
        {
            instance = new Events();
        }
        return instance;
    }
    public void addBroadcast(String key, string value,Transmission recever)
    {
        recever.onBroadcastReceived(key, value);
    }

}

public class A
{
    public A()
    {
        B b = new B();
        Events.getInstance().addBroadcast("Hello", "say hello",b);
    }
}

public class B implements Transmission
{
    @override
    public void onBroadcastReceived(String key, String value)
    {
        Log.d(key,value);
    }
}


A a = new A();