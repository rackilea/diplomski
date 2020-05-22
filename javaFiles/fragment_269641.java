public class A {

    private static String field;

    public static String getField() {
        return field;
    }

    public static void setField(String field) {
        A.field = field;
    }
}


public class B extends A{

}


public class C extends A{

}


public class Test {

    public static void main(String[] args){
        B.setField("Thank you"); // or 
           new B().setField("Thank you"); 

        System.out.println(C.getField()); // or
            System.out.println(new C().getField());

  // it will work for object and for class as well
    }
}