public class Test{

public static void print(Object obj){
    System.out.println("Object");
}

public static void print(Test2 obj){
    System.out.println("test 2");
}

public static void print(Test3 obj){
    System.out.println("Test 3");
}


public static void main(String[]args){
    Test.print(null);
}

}