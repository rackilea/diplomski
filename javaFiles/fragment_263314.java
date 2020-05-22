//for loop to calculate the input 
sumOfEggs = 0;
for(int i = pythonAge; i <= maxAge; i++) {
    //initialize currentYearEggs
    currentYearEggs = 35;

    //Calculation for Sum Of All Eggs
    sumOfEggs = sumOfEggs + currentYearEggs;

    //Output data
    System.out.printf("%5d%20d%20d%20d\n", i, previousYearEggs, currentYearEggs, sumOfEggs);

    //calculate the Previous Years eggs
    previousYearEggs = sumOfEggs;


}//end for
overallTotal += sumOfEggs;