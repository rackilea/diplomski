public class EvtListDeserializer extends JsonDeserializer<EventList>
{
    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public EventList deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException
    {
        EventList eventList = new EventList();
        List<Event> listOfEvents = new ArrayList<Event>();
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode eventListNode = oc.readTree(jsonParser);
        ArrayNode node = (ArrayNode) eventListNode.get("evt");
        Iterator<JsonNode> events = node.elements();
        for (; events.hasNext(); )
        {
            JsonNode eventNode = events.next();
            int eventType = eventNode.get("type").asInt();

            Event event;
            if (eventType == EventTypes.MoveEvent.getValue())
            {
                event = mapper.readValue(eventNode.toString(), MoveEvent.class);
            }
            else if (eventType == EventTypes.CopyEvent.getValue())
            {
                event = mapper.readValue(eventNode.toString(), CopyEvent.class);
            }
            else
            {
                throw new InvalidEventTypeException("Invalid event type:" + eventType);
            }

            listOfEvents.add(event);
        }

        eventList.setEvents(listOfEvents);

        return eventList;
    }
}