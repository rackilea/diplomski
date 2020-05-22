public class EntityValueDeserializer extends JsonDeserializer<Object>
{

   public Object deserialize(JsonParser jp, DeserializationContext ctx) throws IOException
   {
      ObjectCodec codec = jp.getCodec();
      JsonNode node = codec.readTree(jp);
      Entity entity = ((Entity) jp.getParsingContext().getCurrentValue());
      return codec.treeToValue(node, entity.valueType);
   }

}