public class Pascaline {
   public static void main(String args[]) {
     int n = 10, i, j;
     int [] f = new int[n];

     f[0] = 1;

     for (i = 1; i != n; i++)
       f[i] = f[i - 1] * i;

     for(i = 0; i < n; i++) {
      for(j = 0; j <= i; j++)
         System.out.print((f[i] / (f[i - j] * f[j])) + " ");
       System.out.println();
     }
   }
}