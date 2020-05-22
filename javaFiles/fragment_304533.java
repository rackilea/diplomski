public interface FirstClassInterface {
       void method1();
   }

   public interface SecondClassInterface {
       void method2();
   }

   public class FirstClass implements FirstClassInterface {
       // ...
   }

   public class SecondClass implements SecondClassInterface  {
       // ...
   }

   public class FirstAndSecondClass implements FirstClassInterface , SecondClassInterface       
    {
       private FirstClassInterface firstclass;
       private SecondClassInterface secondclass;

       public FirstAndSecondClass(FirstClassInterface firstclassinterface, SecondClassInterface   secondclassinterface) {
           this.firstclass= firstclassinterface;
           this.secondclass= secondclassinterface;
       }

       public void method1() {
           this.firstclass.method1();
       }

       public void method2() {
           this.secondclass.method2();
       }

       public static void main(String[] args) {
           FirstAndSecondClass t = new FirstAndSecondClass(new FirstClass(), new SecondClass());
           t.method1();
           t.method2();
       }
   }