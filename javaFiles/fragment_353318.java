public static void main(String[] args) throws Exception
{
  ObjectMapper mapper = new ObjectMapper();

  class MethodLocal {public String key = "method local";}
  System.out.println(mapper.writeValueAsString(new MethodLocal()));
  // {"key":"method local"}

  Object extendsObject = new Object() {public String key = "extends Object";};
  System.out.println(mapper.writeValueAsString(extendsObject));
  // {"key":"extends Object"}
}