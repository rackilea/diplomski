public class Test {

    public  static  void main throws Throwable(String [] args ){

        MyTest mt= new MyTest();
        mt.finalize() // compile time  error  The method finalize() from the type Object is not visible
    }
}