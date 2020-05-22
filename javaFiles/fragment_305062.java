public int countRun( String s, char c )
  {
    int counter = 0;
    boolean foundOne = false;
    for( int i = 0; i < s.length(); i++)
    {
      if( s.charAt(i) == c )
      {
        counter += 1;
        foundOne = true;
      }
      else {
        if(foundOne) break;
      }
    }
    return counter;
  }