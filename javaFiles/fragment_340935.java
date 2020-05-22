boolean isDuplicate(double x, double[] array, int checkUpTo){
    numOfOccurencies = 0;
    for(int i = 0; i <= checkUpTo; i++)
        if(x == array[i])
            numOfOccurencies++;
    return(numOfOccurencies > 1)? true : false;
}