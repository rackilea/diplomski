public class Test {

   class InnerClass{    
   }

   public static void main(String[] args){
      Test test = new Test();
      InnerClass ic = test.new InnerClass();
   }
}