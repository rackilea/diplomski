public class IronGolem extends Pet {
   public static IronGolem from(Map<String, Object> deserializedPet) {
      // here check the map for each thing you need
      return new IronGolem(/*pass in every attribute*/);
   }
}