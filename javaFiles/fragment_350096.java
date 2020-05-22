public class DbEntry{
  List<Integer> integerList;
  List<String> strList;
  public Integer getInt(int index){
    return integerList.get(index);
  }
  public String getStr(int index){
    return strList.get(index);
  }
  //todo: add some constructors/factory methods
}