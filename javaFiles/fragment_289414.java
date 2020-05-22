public class Test {

      public static void main(String args[]) {
         int a = 60;    /* 60 = 0011 1100 */  
         int b = 13;    /* 13 = 0000 1101 */
         int c = 0;

         c = a << 2;     /* 240 = 1111 0000 */
         System.out.println("a << 2 = " + c );
    //this will shift the binary version of a to two bits left side and insert zero in remaining places
         c = a >> 2;     /* 215 = 1111 */
         System.out.println("a >> 2  = " + c );
    //this will shift the binary version of a to left by two bits right  insert zero in remaining places
         c = a >>> 2;     /* 215 = 0000 1111 */
         System.out.println("a >>> 2 = " + c );
//this will shift the binary of a to 3bits right  insert zero in remaining places
      }
    }