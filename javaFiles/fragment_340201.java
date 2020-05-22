int highest = Integer.MIN_VALUE+1; 
 int sec_highest = Integer.MIN_VALUE;
 for(int i : b) //b is array of integers
 {
     if(i>highest)
     {
        sec_highest = highest; //make current highest to second highest
        highest = i; //make current value to highest
     }
     else if(i>sec_highest && i != highest) 
     {
        sec_highest = i;
     }
 }