double depreciationRate = 0.3;  // 0.3 assumes a 30% depreciation each year

 }else if(method.equalsIgnoreCase("double-declining")){
  while(year <= limit)
  {
      System.out.print(year + "\t");
      System.out.print(nf.format(cost) + "\t\t\t");
      depreciation = cost*depreciationRate;                      // This is the "magic" - n% of the book value, so a new value is calculated for each year.
      System.out.print(nf.format(depreciation) + "\t\t\t");
      totalDepreciation += depreciation;
      System.out.print(nf.format(totalDepreciation) + "\n");
      cost -= depreciation;
      year++;
  }