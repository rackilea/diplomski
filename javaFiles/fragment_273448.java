public class Test {

   public static void main(String[] args){

      class ClassA implements TestA {

        public String toString(){
            return "test";
        }
      }
      TestA myObject = new ClassA();
      String myString = myObject.toString();
      System.out.println(myString);
   }
}