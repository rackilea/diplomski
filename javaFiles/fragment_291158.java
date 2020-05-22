public class Main
{ 
     public static void main(String []args)
     {
        // show that all multiples of 65536 yeild 0 when squared
        for(int j = Integer.MIN_VALUE; j <= Integer.MAX_VALUE - 65536; j += 65536)
        {
            if((j*j) != 0)
            {
                System.out.println(j + "^2 != 0");
            }
        }
        System.out.println("Done!");
    }
}