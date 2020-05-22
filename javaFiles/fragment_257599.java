public class Whatever {
  public int mymethod(int one, int two) { return 0; }
  public int myothermethod(int one, int two, int three) { return 0; }
}


public class However extends Whatever
{
   @Override // optional annotation
   public int mymethod(int one, int two)
   {
     int answer = one * two;
     return answer + 3;
   }
}