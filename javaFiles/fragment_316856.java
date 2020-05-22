import java.util.Scanner;

public class DataType 
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      if(in.hasNextByte(2))
         System.out.println("Byte");
      else if(in.hasNextInt())
         System.out.println("Integer");
      else if(in.hasNextFloat())
         System.out.println("Float");
      else if(in.hasNextBoolean())
         System.out.println("Boolean");
      else if(in.hasNext())
         System.out.println("String");
   }
}