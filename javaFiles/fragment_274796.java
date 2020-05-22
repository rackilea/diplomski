private class InfoSerializer implements JsonSerializer<Info>
{
    @Override
    public JsonElement serialize(Info src, Type typeOfSrc,
            JsonSerializationContext context)
    {
         JsonObject obj = new JsonObject();
         obj.addProperty("details", src.getDetails());
         obj.addProperty("hostId", src.getHostId());
         obj.addProperty("dateCreated", src.getDateCreated().toString());
         obj.addProperty("expiryDate", src.getExpiryDate().toString());
         obj.add("alternativeInfo", getGsonInstance().toJsonTree(src.getAlternativeInfo()));
         obj.add("alternativeTimes", getGsonInstance().toJsonTree(src.getAlternativeTimes()));
         return obj;
    }   
}