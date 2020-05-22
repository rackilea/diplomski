public class System{

   public static void main(String[] args) {
      intobj i = new intobj();
      i.value = 10;
      intobj j = new intobj();
      j.value = 10;
     int sum1 = (i.value / 2) + fun(i);
     int sum2 = fun(j) + (j.value / 2);
      System.out.println("%d%d",sum1,sum2 );
   }


   public static int fun(intobj k) {

      k.value += 4;
      return 3 * (k.value) - 1; 
   }
}