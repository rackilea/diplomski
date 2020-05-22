private class TagSerializer implements JsonSerializer<Tag>
{
  public JsonElement serialize(Tag src, Type typeOfSrc, JsonSerializationContext context)
  {
    return new JsonPrimitive(src.toString());
  }
}