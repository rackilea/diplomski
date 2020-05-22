static TypeFactory typeFactory = TypeFactory.defaultInstance();
public static void main(String[] args) {
    TestRig.<List<String>>pharaoh();                  // oh, that's bad
    TestRig.sam(new TypeReference<List<String>>(){}); // no, that's good
}
public static <T> void pharaoh() {
    TypeReference<?> typeRef = new TypeReference<T>() {};
    JavaType typeT = typeFactory.constructType(typeRef); // this is what happens inside ObjectMapper
    System.out.println("from generic  TypeReference: " + typeRef.getType().toString());
    System.out.println("from generic  TypeReference: " + typeT.toString());
}
public static <T> void sam(TypeReference<T> typeRef) {
    JavaType typeT = typeFactory.constructType(typeRef); // this is what happens inside ObjectMapper
    System.out.println("from concrete TypeReference: " + typeRef.getType().toString());
    System.out.println("from concrete TypeReference: " + typeT.toString());
}