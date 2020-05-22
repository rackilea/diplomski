class MyClass{
    public String myString = "class level string";

    public void test(String testString){
         String myString = "method level string";
         // you have shadowed the class level variable by defining a method-level local variable.

         System.out.println(myString);  // will print "method level string"
    }
}