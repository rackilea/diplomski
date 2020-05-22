public class MyClass{

    public void myMethod(String let) {
           switch (let) {
               case "A":
                   throw new Exception();
                   break;

               default:
                   break;
           }
      }

}