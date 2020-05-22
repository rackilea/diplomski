for(int k = 1; k < minimum.length; k++)
{
   int count1 = 0, count2 = 0, pos = k;
   if (coins[pos][1] > 0)
      while (true)
      {
         if (coins[pos][0] == 3) count1++;
         if (coins[pos][0] == 4) count2++;
         if (coins[pos][1] == 3) count1++;
         if (coins[pos][1] == 4) count2++;
         if (coins[pos][1] < 5) // stop when 0/3/4
            break;
         pos = coins[pos][1];
      }
   System.out.println(k + " " + minimum[k] + " " +
                      count1 + " of coin 3, " + count2 + " of coin 4");
}