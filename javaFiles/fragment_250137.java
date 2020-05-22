import java.util.Map;
   import java.util.HashMap;

public class CityMap{

public static void main(String[] args)
{  
  String _city;
  Map<String, Integer> cityTable = buildTable();
}

public static Map<String, Integer> buildTable(){
 String aCity;
 Map<String, Command> result = new HashMap<String, Command>();

 aCity = new City();
 result.put("NYC", 100000);


 aCity = new City();
 result.put("Boston", 500);

  return result;
  }
}