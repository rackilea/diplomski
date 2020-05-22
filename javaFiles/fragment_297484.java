class Demo {
  int add(int a,int b) {
    return a+b;
  }
}

class Base extends Demo {
  int add(int a, int b) {
    return 0;
  }

  int add(int a,int b,int c) {
    return a+b+c;
  }
}

public class HelloWorld {
  public static void main(String []args) {
    Demo d=new Base();
    // System.out.println(d.add(2, 3, 4)); // compilation error  
    System.out.println(d.add(2,3));  // returns 0, dynamic binding

    System.out.println(((Base)d).add(1, 2, 3)); // compiles and returns 6
  }
}