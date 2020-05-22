@Converter
public class MyConverter implements AttributeConverter<LocalTime, Time> {

    @Override
    public Time convertToDatabaseColumn(LocalTime localTime) {
        if(localTime == null){
            return null;
        }

        // convert LocalTime to java.sql.Time
    }

    @Override
    public LocalTime convertToEntityAttribute(Time time) {
        if(time == null){
            return null;
        }

        // convert java.sql.Time to LocalTime
    }
}