class HelloWorld {

    public static native void print();  //native method

    static   //static initializer code
    {
        System.loadLibrary("CLibHelloWorld");
    } 

}