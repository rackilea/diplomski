// java: 
void someFunction(String yourString) {yourString = "bye";}
void test() {
    String test = "hi";
    someFunction(test);
    System.out.println(test); // prints "hi", not "bye"!
}