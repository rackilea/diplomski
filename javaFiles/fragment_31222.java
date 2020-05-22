// SALES.add(0,000); remove this
    addHash();

    for(int i = 0;i< 12;i++){ // iterate from 0 to 11
        System.out.println("Enter sales for " + Months.get(i+1)); // add 1 when you need
                                                                  // to obtain month name
        int value= in.nextInt();
        SALES.add(i,value); // or simply SALES.add(value);
    }

    //Get Max
    int max = Collections.max(SALES);
    int maxIndex = SALES.indexOf(max);
    System.out.println("Highest sales were in " + Months.get(maxIndex+1));

    //Get Min
    int min = Collections.min(SALES);
    int minIndex = SALES.indexOf(min);
    System.out.println("Lowest sales were in " + Months.get(minIndex+1));

    //Gets all the sales
    for(int i=0;i<12;i++){
        System.out.println(Months.get(i+1) + ": " + SALES.get(i));
    }