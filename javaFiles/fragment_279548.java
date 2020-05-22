public class Citizen {
    ...
    @JsonDeserializer(using=MyListDeserializer.class)
    @JsonSerializer(using=MyListSerializer.class) 
    public void setTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }
}

public class MyListSerializer extends JsonSerializer<Object> {

    @Override
    public void serialize(Object list, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        @SuppressWarnings("rawtypes")
        jgen.writeStartObject();
        String type = getListType(list);
        jgen.writeStringField("listType", type);
        jgen.writeObjectField("list", list)
    }
}