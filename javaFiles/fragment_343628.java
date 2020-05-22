if (1 == coinFace)
 {
     //Print H  for heads and increment the headCount
     System.out.print( "H" );
     headCount++;
     consecutiveHeads++;
     if(consecutiveHeads > longestHeadStreak)
     {
          longestHeadStreak = consecutiveHeads;
     }
 }