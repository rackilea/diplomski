public class Event extends SugarRecord<Event> {
    public String name;
    public int year;
    public int month;
    public int day;
    public int hour;
    public int minute;

    public Event() { }
    public Event(String name, int year, int month, int day, int hour, int minute) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }
}