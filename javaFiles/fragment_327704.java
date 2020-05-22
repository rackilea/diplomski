public class Elfsort{
   public static int[] sort(int[] packages, int digit){
      if(packages.length<2) return packages;
      if(digit>=0){
         int[][] d=new int[10][];
         int tmp=-1;
         for(int i:packages){
             tmp=i/pot(digit);
             d[tmp%10]=putIn(d[tmp%10],i);
         }
         digit--;
         int a=0;
         for(int i=0; i<10; i++){
             sort(d[i],digit);
             for(int j:d[i]){
                 packages[a++]=j;
             }
         }
      }
      return packages;
  }
}