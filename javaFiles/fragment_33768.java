public class Tokenizer {

  public String get(IniParam<String> iniParam) {
    int position = iniParam.getPosition();
    //...
    return "some string from .ini";
  }

  public int get(IniParam<Integer> iniParam) {
    // ... 
    // return some integer from .ini
  }
}