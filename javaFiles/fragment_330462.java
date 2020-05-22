public class Foo {

  static void someMethodThatTakesAHashMap(Map<String, String> map) {
    System.out.println(map);  
  }

  public static void main(String[] args) {
    HashMap<String, String> map  = new HashMap<String, String>();
    map.put("a","value-a"); 
    map.put("c","value-c");
    someMethodThatTakesAHashMap(map);
  }
}