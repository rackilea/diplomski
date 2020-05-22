public class DbEntry{
  Map<String,Integer> integerMap;
  Map<String,String> strMap;
  public Integer getInt(String key){
    return integerMap.get(key);
  }
  public String getStr(String key){
    return strMap.get(key);
  }
  //todo: add some constructors/factory methods
}