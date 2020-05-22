public double binaryInsertionSort(long array[], int value, int left, int right) {

setType("Binary Insertion Sort");

long temp;

int y=0;

//int left, right;

double numOfSwap = 0, numOfComparisons = 0;

double startTime = System.nanoTime();

for (int x = 1; x < array.length; x++) {

temp = array[x];

numOfSwap++;

y=left;

right = x;

if (left>right){
return -1;
}

int middle = (left + right)/2;

if (array[middle] == value){

    numOfComparisons++;
    return middle;

} else if (array[middle]>value){

    numOfComparisons++;
    return binaryInsertionSort(array, value,left, middle -1);

} else{

    numOfComparisons++;    
    return binaryInsertionSort (array, value, middle +1, right);
    }

}

double endTime = System.nanoTime();

setSwap(numOfSwap / 3);

setComparisons(numOfComparisons);

setTime(endTime - startTime);

return getTime();

}
`