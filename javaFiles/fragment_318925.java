enum Operator {

 BITSHIFT { ... }, ADD { ... }, XOR { ... }, //...etc

 Operator public static which(String s) { //...return the correct one
 }

 public abstract int apply(int a, int b); //...defined explicitly for each enum

}