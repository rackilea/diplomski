public int countRun( String s, char c )
  {
    int counter = 0;
    for( int i = 0; i < s.length(); i++)
    {
      if( s.charAt(i) == c )  counter++;
      else if(counter>0) break;
    }
    return counter;
  }