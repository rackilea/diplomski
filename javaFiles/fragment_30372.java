public class MyClass{

      private string value;

      public myFunction(){
        value = toto; // this will change the value of the attribute directly
      }

     public static void main(String[] args) {
           MyClass myClass = new MyClass();
           myClass.myFunction(); // The new value is saved at the class level
      }
 }