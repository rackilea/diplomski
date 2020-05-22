public interface SayHello() {
    public void sayHello();
}

public class MisterV {    

    public static void main(String[] args) {
        SayHello hello = new SayHello() {
           public void sayHello() {
               System.out.println("Hello World");
           }
        };

        hello.sayHello();
    }
}