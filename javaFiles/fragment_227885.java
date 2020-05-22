public class Event {
    private int year;
    private int month;
    private int numOfCities;

    /** default constructor */
    public Event() {
        year = month = numOfCities = 0; // unnecessary, as 0 is the default value
    }

    /** copy constructor */
    public Event(Event other) {
        year = other.year;
        month = other.month;
        numOfCities = other.numOfCities
    }
    ...
}