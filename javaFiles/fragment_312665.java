public class SoApp
{

   /**
    * @param args
    * @throws Exception
    */
   public static void main(String[] args) throws Exception
   {
      System.out.println("Hello World!");

      String s = "[{\"user\":\"TestCity\",\"role\":\"TestCountry\"},{\"user\":\"TestCity\",\"role\":\"TestCountry\"}]";
      StringReader sr = new StringReader("{\"user\":\"TestCity\",\"role\":\"TestCountry\"}");
      //UserRole user = mapper.readValue(sr, UserRole.class);

      mapJsonToObjectList(new UserRole(),s,UserRole.class);

   }

   protected static <T> List<T> mapJsonToObjectList(T typeDef,String json,Class clazz) throws Exception
   {
      List<T> list;
      ObjectMapper mapper = new ObjectMapper();
      System.out.println(json);
      TypeFactory t = TypeFactory.defaultInstance();
      list = mapper.readValue(json, t.constructCollectionType(ArrayList.class,clazz));

      System.out.println(list);
      System.out.println(list.get(0).getClass());
      return list;
   }
}