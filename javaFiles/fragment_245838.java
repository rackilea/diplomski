import java.util.Arrays;
    class MyStringTest{
      public static String[] reverseOrder(String word1, String word2,    
                                    String word3) {
        // int a = word1.length();
        // int b = word2.length();
        // int c = word3.length();

        // String x;
        // String y;
        // String z;

        String x = word1.toUpperCase(); 
        String y = word2.toUpperCase();
        String z = word3.toUpperCase();


        String[] r = new String[]{x, y, z};
        // return the array
        return r;  // check the return type


      }
      public static void main(String [] args){
        String [] r = reverseOrder("run", "roll", "jump");
        System.out.println(Arrays.toString(r));


      }

    }