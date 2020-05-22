/** codes you try to execute/write **/
void withStringValues() {
    Map<String,String> object = raw(Map<String,String>.class);
    String string = object.get("string"); // Ok
    String map    = object.get("map");    // ClassCastException
    Map    map    = object.get("map");    // Doesn't compile
}