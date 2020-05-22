public class DayOfWeekWithTime {
    // Member fields
    DayOfWeek dayOfWeek ;
    LocalTime localTime ;

    // Constructor
    public DayOfWeekWithTime ( DayOfWeek dayOfWeek , LocalTime localTime ) {
        Objects.requireNonNull( dayOfWeek ) ;
        Objects.requireNonNull( localTime ) ;
        this.dayOfWeek = dayOfWeek ;
        this.localTime = localTime ;
    }
}