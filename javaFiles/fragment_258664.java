public class HootUtility // singleton because developer was a goofball.
{
   ...
   public void blammy(...) { ... }
   public HootUtility getInstance() { ... }
}

... somewhere in the code.

HootUtility.getInstance().blammy(...);  // This is silly.