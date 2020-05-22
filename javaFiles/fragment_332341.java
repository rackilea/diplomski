@org.simpleframework.xml.Root
@Namespace(reference="http://domain/parent", prefix="bla")
class Root {
   @Element
   @Path("bla:children")
   @Namespace(reference="http://domain/parent", prefix="bla")
   private final String innerChildren;

   public Root(String name){
       innerChildren = name;
   }
}