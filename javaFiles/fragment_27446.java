public class act_numTria {
   public static void main(String[] args) {
      int z = 9;
      for(int x=1;x<=4;x++){
         for(int y=4;y>=x;y--){
            System.out.print(z-y+1);
         }
         z = z - (4 - x);
         System.out.print("\n");
      }
   }
}