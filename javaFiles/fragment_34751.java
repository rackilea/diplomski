public class JsonStdDateSerializer
extends JsonSerializer<Date> {
  private static final DateFormat iso8601Format =
    StdDateFormat.getBlueprintISO8601Format();

  @Override
  public void serialize(
    Date date, JsonGenerator jgen, SerializerProvider provider)
  throws IOException, JsonProcessingException {

    // clone because DateFormat is not thread-safe
    DateFormat myformat = (DateFormat) iso8601Format.clone();
    String formattedDate = myformat.format(date);
    jgen.writeString(formattedDate);
  }
}