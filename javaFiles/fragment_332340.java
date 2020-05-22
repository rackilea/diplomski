@org.simpleframework.xml.Root
class Root {
   @Element
   @Path("children")
   private final String innerChildren;

   public Root(String name){
       innerChildren = name;
   }
}