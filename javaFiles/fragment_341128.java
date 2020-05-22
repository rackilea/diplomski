@RequestMapping(value = "/getsector", method = RequestMethod.POST)
public @ResponseBody String getSector(@RequestBody Market market) throws JsonGenerationException, JsonMappingException, IOException
{
    List<String> sectors = new ArrayList<String>();
    sectors.add("Auto"); sectors.add("Industrial"); sectors.add("Analog");
    return sectors;
}


public class Market
{
  String market;

  //getter and setter...
}