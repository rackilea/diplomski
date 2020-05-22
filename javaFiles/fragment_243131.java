public static void FindTheDouble() {

double LookFor = 2.29195;

for (double i = 1.0; i <= 5.0; i+=0.00005) {
    System.out.println(i);
       if (i == LookFor) {
           System.out.println();
           System.out.println("Found the double: "+LookFor);
           break;          
       }   
   }
}