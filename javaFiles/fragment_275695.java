public class HelloWorld{

    public class HellowWorld2{
        public HellowWorld2(){
            System.out.println("Hellow World2");
        }
    }

     public static void main(String []args){
        System.out.println("Hello World");
        new HelloWorld().new HellowWorld2(); //The instantiation
     }
}