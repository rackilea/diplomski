public class Myclass extends JUnitStories
{

 public Myclass(){
   configuredEmbedder().useMetaFilters(Arrays.asList("-skip"));
 }

 @Override
 public Configuration configuration(){
    return new MostUsefulConfiguration()...
  }

}