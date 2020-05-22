int [] anArray1 = {10,20,8,150,300};
    int [] anArray2 = {205,20,30,50,80};
    int totalResult = 0;

    for (int i=0; i < anArray1.length && i < anArray2.length; i++)
    {
        int result = anArray1[i]+anArray2[i];
        totalResult += result;
        System.out.println(anArray1[i] + " + " + anArray2[i] + " = " + result);
    }
    System.out.println("Total = " + totalResult);