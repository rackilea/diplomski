public class A {

     private String a;

     @JsonUnwrapped
     private B b;
}

public class B {

     private String b1;

     private String b2;

}