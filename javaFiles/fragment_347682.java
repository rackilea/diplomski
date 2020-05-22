public class Chapter4Exercise2 {
  public static void main(String[] args) {

  int tableSize = 10;

  int[][] table = new int[tableSize][tableSize];

  for(int i=0; i < table.length; i++) {
    for (int j=0; j < table[i].length; j++) {
      table[i][j] = (i+1)*(j+1);

      if(table[i][j] < 10) //Where i*j < 10
        System.out.print("   "+(table[i][j])+" ");  
      else if(table[i][j] < 100) //Where i*j < 100
        System.out.print("  "+(table[i][j])+" ");
      else //Where i*j < 1000
        System.out.print(" "+(table[i][j])+" ");
    }
  System.out.println("");
}