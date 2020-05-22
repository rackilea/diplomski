public class HolaMundo {

    public static class AnotherClass {

       public void hello(){
           System.out.println("Hello");
       }

       public static void hola(){
           System.out.println("Hola");
       }
    }

    public static void main(String[] args) {
        HolaMundo.AnotherClass.hola();

        HolaMundo.AnotherClass holaAnother = new HolaMundo.AnotherClass();
        holaAnother.hello();

    }
}