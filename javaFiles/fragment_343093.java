public class EventString
{
    private String                  myString;

    private List<MyEventListener>   eventListeners;

    public EventString(String myString)
    {
        this.myString = myString;
        this.eventListeners = new ArrayList<MyEventListener>();
    }

    public void addMyEventListener(MyEventListener evtListener)
    {
        this.eventListeners.add(evtListener);
    }

    public void setValue(String val)
    {
        myString = val;

        if (val.equals("hello world"))
        {
            eventListeners.forEach((el) -> el.onMyEvent());
        }
    }
}