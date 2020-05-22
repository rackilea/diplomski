public abstract class Whatever {
   public abstract int mymethod(int one, int two);
   public abstract int myothermethod(int one, int two, int three);
}

public class However extends Whatever
{
   public int mymethod(int one, int two)
   {
     int answer = one * two;
     return answer + 3;
   }
   public int myothermethod(int one, int two, int three) {
     return 0;
   }
}