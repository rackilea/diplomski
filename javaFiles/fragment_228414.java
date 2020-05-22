public static int findMin(int[] numList, int start, int end){

        int minVal= numList[start];
        int minIndex = start;
        for (int i=start; i <end; i++) {
            if(numList[i] <minVal){
               minIndex=i;
               minVal=numList[i];
            }
        }

        return minIndex;
    }