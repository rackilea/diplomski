@Root
public class Example {

   @ElementListUnion({
      @ElementList(entry="int", type=Integer.class, inline=true),
      @ElementList(entry="date", type=Date.class, inline=true),
      @ElementList(entry="text", type=String.class, inline=true)
   })
   private List<Object> list;
}