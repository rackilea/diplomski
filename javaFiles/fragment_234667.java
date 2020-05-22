public class IntegerObject implements DataType{
  private final Map<Integer, Object> attributeData = new LinkedHashMap<>();

  public Map<Integer, Integer> getAttributeData() {
    return attributeData;
  }

  @Override
  public void putDataToObject(int key, Object value){
    attributeData.put(key, value);
  }  
}