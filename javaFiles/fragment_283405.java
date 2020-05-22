@Entity
public class MyEntity {
    @Convert(converter = YearMonthConverter.class)
    private YearMonth date; //how to persist?
    //some more properties
}