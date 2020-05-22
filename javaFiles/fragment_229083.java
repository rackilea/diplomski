public class MyClass{

    private String string;

    public MyClass(){
        method();
    }

    public MyClass(String s){
        string = s;
        method();
    }

    public void method(){
        System.out.println(string);
    }
}