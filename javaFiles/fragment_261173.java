public static int consecSum(int startingNum, int numInts){
    int nextNum = startingNum + 1;
    for (int i = numInts; i>0; i--){
        startingNum += nextNum;
        nextNum++;
    }
    return startingNum;
}