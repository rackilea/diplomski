@Entity 
public class Person { 
    // . . .

    @Temporal(TemporalType.TIMESTAMP)
    private GregorianCalendar lastUpdated;

    // . . .
}