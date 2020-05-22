public class headerComponent{
  ValueMap property = resource.adaptTo(ValueMap.class);

public void getMeProp()
{
  if(property != null) {
    pageHeader = property.get("pageHeader", "");
  }
}

}