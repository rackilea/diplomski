@TypeDef (name="bigIntCalendar", typeClass=CalendarBigIntType.class)
@Entity
public class MyEntity {
    @Type(type="bigIntCalendar")
    private Calendar myDate;
}