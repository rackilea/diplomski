public class EventXML
{
    public String name;
    public String ip;
    public MyData myData = new MyData();
    public String eventName;

    public static class MyData {
        public Date date;
        public String dateFormat;
    }
}