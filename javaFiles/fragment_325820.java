class Bound
{
private:
  const int min = 10;
  const int max = 100;
  int var;
public:
  Bound( int x )
  {
    if ( x > max )
       var = max;
    else if ( x < min )
       var = min;
    else
       var = x;
  }

  Bound& operator == ( int x )
  {
    // On same line as constructor 
  }
};