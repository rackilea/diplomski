public class IniParam<T> {

  public static final IniParam<String> NAME = new IniParam<String>(2, String.class);

  public static final IniParam<String> UNITS = new IniParam<String>(3, String.class);

  public static final IniParam<Integer> LOWER = new IniParam<Integer>(4, Integer.class);

  public static final IniParam<Integer> UPPER = new IniParam<Integer>(5, Integer.class);

  private final int position;

  private final Class<? extends T> type;

  private IniParam(int position, Class<? extends T> type) {
    this.position = position;
    this.type = type;
  }

  public int getPosition() {
    return position;
  }

  public Class<? extends T> getType() {
    return type;
  }
}


public class Tokenizer {

  public <T> T get(IniParam<T> iniParam) {
    int position = iniParam.getPosition();
    Class<? extends T> type = iniParam.getType();
    if (type == String.class) {
      //...
      return type.cast("some string from .ini");        
    } else if (type == Integer.class) {
      //...
      // Integer result = ...;
      return type.cast(result);
    } else {
      throw new IllegalArgumentException("Unexpected IniParam type: " + type);
    }      
  }
}