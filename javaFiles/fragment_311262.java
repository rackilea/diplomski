int count = 0;
for (Integer i : uniqueNumbers) {                 //For every number in the Set
    for (int j = 0; j < usersNums.length; j++) {  //Look at every number in the array
        if (i == usersNums[j]) { count++; }       //If the same, count++
    }
    System.out.print(i + " - " + count + "\n");   //Print results
    count = 0;                                    //Reset Count
}