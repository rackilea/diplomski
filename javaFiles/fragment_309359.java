void foo() {
  String x = null;
  String y;

  System.out.println(x)  // Fine, prints null
  System.out.println(y); // Compile-time error
}