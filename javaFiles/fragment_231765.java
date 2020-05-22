while((inputValues = BR.readLine()) != null) {
    inputArr = inputValues.split("\\s");
    int[] intScoresArr = new int[inputArr.length]; // <============= here
    for(int i = 0; i < inputArr.length; i++) {
        intScoresArr[i] = Integer.parseInt(inputArr[i]);
        count++;
    }
    //Call calcMean calculate average
    average = calcMean(intScoresArr, count);
    System.out.println(NF.format(average));

    //Call calcMedian, calculate median
    median = calcMedian(intScoresArr, count);
    System.out.println(median); 
}