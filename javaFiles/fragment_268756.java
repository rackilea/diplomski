class Alpha
{
      class Beta ( ) { }
}

class Gamma extends Alpha . Beta
{
      // important to get the constructor right or else the whole thing fails
      Gamma ( Alpha alpha )
      {
             alpha . super ( ) ;
      }
}