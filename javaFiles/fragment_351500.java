public static boolean aGoodBase (char c) {                
    char [] charArray = { 'A', 'G', 'C', 'T' };
    boolean aBase;

    if (c == 'A' || c == 'G' || c == 'C' || c == 'T') 
    {
      aBase = true;     
    } 
    else 
    {
      aBase = false;
    }
    System.out.println(aBase);
    return aBase;
}