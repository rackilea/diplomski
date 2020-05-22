public class AddNumbers{
   public static void main(String[] args){
       int something = Add(args);    
        System.out.println(something);
  }
    public static int Add(String[] args){
      int a = Integer.parseInt(args[0]);
      int b = Integer.parseInt(args[1]);
      int c = a+b;
      return c;
 }
}