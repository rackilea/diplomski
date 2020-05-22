@TypeDef(name = "calendarType", typeClass = CalendarType.class)
@Entity
@Table
public class Entity {

    @Type(type = "calendarType")
    @Column(nullable = false)
    private Calendar transmissionDate;

    ...
}