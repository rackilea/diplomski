class HelloWorld{
    int i;
    void method(){
        System.out.println("Inside Method");
    }
    public static void main(String... args){
        HelloWorld obj = new HelloWorld();
        obj.method();
    }
}