public class CustomDateSerializer extends JsonSerializer<Date> {

@Override
public void serialize(Date date, JsonGenerator jgen, SerializerProvider provider) throws IOException,
        JsonProcessingException {

    // below methods of Date object is deprecated - consider this as sample example 
    int idate = date.getDate();
    int day = date.getDay();
    int hours = date.getHours();
    int minutes = date.getMinutes();
    int month = date.getMonth();
    int seconds = date.getSeconds();
    long time = date.getTime();
    int timezoneOffset = date.getTimezoneOffset();
    int year = date.getYear();

    jgen.writeStartObject();

    jgen.writeNumberField("date", idate);
    jgen.writeNumberField("day", day);
    jgen.writeNumberField("hours", hours);
    jgen.writeNumberField("minutes", minutes);
    jgen.writeNumberField("month", month);
    jgen.writeNumberField("seconds", seconds);
    jgen.writeNumberField("time", time);
    jgen.writeNumberField("timezoneOffset", timezoneOffset);
    jgen.writeNumberField("year", year);

    jgen.writeEndObject();      
}

@Override
public Class<Date> handledType() {
    return Date.class;
}