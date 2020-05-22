temps[i] = in.nextInt();  // This is sensible enough
closest = Math.abs(temps[0]); // Every time your loop runs, the closest value to 0 is... the absolute value of the first int in the array?
//System.err.println(temps[i]);
if (closest > 0)  // This is only false if closest is 0
    {
        if (closest > i) // This makes the outer if redundant, since i >= 0. It's also not clear what the point of this condition even is
        {
           closest = i; // Here's the big one: you're setting closest to your iterator, the index of the current number in the array instead of the number itself. 
        }
     }
       else if (closest < 0) // This is never true, since absolute values are always >=0
       {
         if (closest < i)
         {
             closest = i;
         }
       }
    }