public class PetAdapter 
           implements JsonSerializer<Pet>, JsonDeserializer<Pet> {
  private final Gson gson = new Gson();

  @Override
  public Pet deserialize(JsonElement jsonElement, Type typeOfT, 
      JsonDeserializationContext context) throws JsonParseException {
     EntityType entityType = EntityType.valueOf(jsonElement.getAsJsonObject().get("entityType").getAsString());

      switch (entityType) {
        case IRON_GOLEM:
            return gson.fromJson(jsonElement, EcoPet.class);
        case WOLF:
            return gson.fromJson(jsonElement, BoostPet.class);
        case MAGMA_CUBE:
            return gson.fromJson(jsonElement, CombatPet.class);
        default:
            throw new JsonParseException("Invalid PetType");
      }
  }

  @Override
  public JsonElement serialize(Pet src, Type typeOfSrc, JsonSerializationContext context) {
    return gson.toJson(src);
  }
}