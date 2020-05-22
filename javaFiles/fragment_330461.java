class Foo {

  static void someMethodThatTakesAHashMap(HashMap<String, String> map) {
    System.out.println(map);  
  }

  public static void main(String[] args) {
    someMethodThatTakesAHashMap(new HashMap<String, String>(){{put("a","value-a"); put("c","value-c");}});
  }
}