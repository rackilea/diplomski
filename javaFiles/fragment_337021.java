public static enum Weekday { 
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class Customer {
    private Multimap<WeekDay, String> items = ArrayListMultimap.create();
    // getters, setters etc
}