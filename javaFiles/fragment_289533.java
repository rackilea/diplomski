@SuppressWarnings("serial")
public class DunnoDeserializer extends StdDeserializer<Dunno>
{
    public DunnoDeserializer()
    {
        this(null);
    }

    public DunnoDeserializer(Class<?> vc)
    {
        super(vc);
    }

    @Override
    public Dunno deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException
    {
        Dunno dunno = new Dunno();
        // first parse the input into a map, which is more convenient to work with
        @SuppressWarnings("unchecked")
        Map<String, Object> values = jp.getCodec().readValue(jp, Map.class);
        dunno.name = values.containsKey("name") ? values.get("name").toString() : "empty";
        String unit = values.containsKey("unit") ? values.get("unit").toString() : "default-units";
        if (values.containsKey("widthValue")) {
            dunno.width = new ValueWithUnit();
            dunno.width.value = ((Number)values.get("widthValue")).floatValue();
            dunno.width.unit = unit;
        }
        if (values.containsKey("heightValue")) {
            dunno.height = new ValueWithUnit();
            dunno.height.value = ((Number)values.get("heightValue")).floatValue();
            dunno.height.unit = unit;
        }
        if (values.containsKey("depthValue")) {
            dunno.depth = new ValueWithUnit();
            dunno.depth.value = ((Number)values.get("depthValue")).floatValue();
            dunno.depth.unit = unit;
        }
        System.out.println(values);
        values.values().forEach(v -> System.out.println(v.getClass()));
        return dunno;
    }
}