int lastSign = 0;
int lastCrossing = 0;
float nextZeroCrossing( float newSample ) {
   int thisSign = newSample > 0 ? 1 : -1 ;
   if( thisSign != lastSign ) {
      lastSign = thisSign;
      //zero crossing has happened. Update our estimate of Zr using lastCrossing and return that
   } else {
      ++lastCrossing;
      //zero crossing has not happened. Return existing Zr
   }
}