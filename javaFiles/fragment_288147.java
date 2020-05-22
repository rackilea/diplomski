public static void main(String[] args) {

  // try the for loop with n = 0 vs. n = 1
  for (int n = 1; n <= 10; n++) {
     // line added below for debugging. To remove later:
     System.out.println("\nn is: " + n); 

     String format = "%" + (3 * n) + "s"; 
     System.out.printf(format, "My string");
  }      
}