public class File1
 {
    public static int[] dataArray = new int[100]; 

    static  
     {
  for (int i=0; i<100; i++)
    {
     dataArray[i] = i;
    }
     }

}

public class File2
 {
   private static int[] data = File1.dataArray; // makes "data" refer to the SAME array as File1.dataArray

   public static void main(String[] args)
    {
  File2 file2 = new File2();

      file2.data[20] = -567;  // this changes File1.dataArray also!

      System.out.println(File1.dataArray[20]); // prints -567
    } 
 }