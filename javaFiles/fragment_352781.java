public class Interest {

  public static void main(String[] args) {
    int months = 12;
    int deposit = 1000;

    double[] sbalance; 
    double[] fbalance; 
    double[] interest; 
    sbalance = new double[months]; 
    fbalance = new double[months]; 
    interest = new double[months];  
    for (int q = 1; q <= months; q++) {
      System.out.format ("Month %d%n", q); 
      System.out.format ("%18.2f%n", sbalance[q-1]); 
      System.out.format ("%18.2f%n", interest [q-1]); 
      System.out.format ("%18.2f%n", (double)deposit);
      System.out.format ("%18.2f%n", fbalance [q-1]); 
    }

  }

}