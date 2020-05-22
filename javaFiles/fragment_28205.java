b = random();

do
{
     input a;
     if( a != b )
     {
         if(a < b )
         {
              print "Too low";
         }
         else
         {
              print "Too high";
         }
     }
} while( a != b );

print "You got it correct"