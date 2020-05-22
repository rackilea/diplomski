//This will print 6 to the std output
public class HelloWorld{

     public static void main(String []args){
        Child test = new Child();
        System.out.println(test.getArrFirst());
     }


     public static abstract class Parent{
        int[] abc;

        public int getArrFirst(){
            return abc[1];
        }
     }

     public static class Child extends Parent{

         public Child(){
             abc = new int[10];
             abc[1] = 6;
         }
     }
}