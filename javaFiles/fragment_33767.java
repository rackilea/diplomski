public class IniParam<T> {

  public static final IniParam<String> NAME = new IniParam<String>(2);

  public static final IniParam<String> UNITS = new IniParam<String>(3);

  public static final IniParam<Integer> LOWER = new IniParam<Integer>(4);

  public static final IniParam<Integer> UPPER = new IniParam<Integer>(5);

  private final int position;

  private IniParam(int position) {
    this.position = position;
  }

  public int getPosition() {
    return position;
  }    
}