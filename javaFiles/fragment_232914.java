public class ItemTypeSerializer extends JsonSerializer<ItemType> 
{
    @Override
    public void serialize(ItemType value, JsonGenerator jgen, 
                    SerializerProvider provider) 
                    throws IOException, JsonProcessingException 
    {
        jgen.writeString(value.name);
    }

}

@JsonSerialize(using = ItemTypeSerializer.class)
class ItemType
{
    String name;
    int somethingElse;
}