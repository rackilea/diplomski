class Example{
    boolean value1;//valid, initialized to false
    public void doStuff(){
        boolean value2;//valid, but uninitialized
        System.out.println(value1);//prints "false" (assuming value1 hasn't been changed)
        System.out.println(value2);//invalid, because value2 isn't initialized. This line won't compile.