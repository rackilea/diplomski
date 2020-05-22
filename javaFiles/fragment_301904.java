for (every coin)
  for (int j=0; j<=3000000; j++)
    if (a[j] != 0)
      // j is a possible sum so far
      new_possible_sum = j + this_coin
      a[new_possible_sum] = 1