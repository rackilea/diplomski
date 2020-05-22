public static void mergeHalves(int[] array, int[] secondaryArray, int leftStart, int rightEnd){
int leftStartCopy = leftStart;
int leftEnd = (leftStart + rightEnd)/2;
int rightStart = leftEnd + 1;
int index = 0;

while ((leftStart <= leftEnd) && (rightStart <= rightEnd)){
    if(array[leftStart] <= array[rightStart]){
        secondaryArray[index] = array[leftStart];
        leftStart++;
    }else {
        secondaryArray[index] = array[rightStart];
        rightStart++;
    }
    index++;
}

System.arraycopy(array,rightStart,secondaryArray,index,rightEnd-rightStart+1);
System.arraycopy(array,leftStart,secondaryArray,index,leftEnd-leftStart+1);
System.arraycopy(secondaryArray,0,array,leftStartCopy,rightEnd-leftStartCopy+1);}