private class VkAudioAlbumsResponseDeserializer 
    implements JsonDeserializer<VkAudioAlbumsResponse> {

  @Override
  public VkAudioAlbumsResponse deserialize(JsonElement json, Type type,
        JsonDeserializationContext context) throws JsonParseException {

    JsonArray jArray = (JsonArray) json;

    int firstInteger = jArray.get(0); //ignore the 1st int

    VkAudioAlbumsResponse vkAudioAlbumsResponse = new VkAudioAlbumsResponse();

    for (int i=1; i<jArray.size(); i++) {
      JsonObject jObject = (JsonObject) jArray.get(i);
      //assuming you have the suitable constructor...
      VkAudioAlbum album = new VkAudioAlbum(jObject.get("owner_id").getAsInt(), 
                                            jObject.get("album_id").getAsInt(), 
                                            jObject.get("title").getAsString());
      vkAudioAlbumsResponse.getResponse().add(album);
    }

    return vkAudioAlbumsResponse;
  }  
}