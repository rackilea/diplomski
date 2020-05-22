//demo for MyClass that will have copy constructor: 
//         public MyClass(MyClass original)
public static void main(String[] args) throws Exception {
    MyClass mc = new MyClass("someString", 42);

    Test<MyClass> test = new Test<>();
    MyClass copy = test.createCopy(mc);

    System.out.println(copy.getSomeString());
    System.out.println(copy.getSomeNumber());
}