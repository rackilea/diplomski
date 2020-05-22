public class CustomLocalDateArrayDeserializer extends JsonDeserializer<LocalDate[]> {

  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  @Override
  public LocalDate[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    ArrayList<LocalDate> list = new ArrayList<>();
    JsonToken currentToken = p.getCurrentToken();
    if (currentToken != JsonToken.START_ARRAY) {
      throw new JsonMappingException(p, "Not an array!");
    }

    currentToken = p.nextToken();

    while (currentToken != JsonToken.END_ARRAY) {
      if (currentToken != JsonToken.VALUE_STRING) {
        throw new JsonMappingException(p, "Not a string element!");
      }

      LocalDate localDate = LocalDate.parse(p.getValueAsString(), formatter);
      list.add(localDate);

      currentToken = p.nextToken();
    }

    return list.toArray(new LocalDate[0]);
  }
}