public interface Whatever {
   public int mymethod(int one, int two);
   public int myothermethod(int one, int two, int three);
}

public class However implements Whatever
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