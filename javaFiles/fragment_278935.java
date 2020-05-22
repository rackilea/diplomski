long[] sortedArr = ...
int index = Arrays.binarySearch (sortedArr, value);
int first = index;
int last = index;
if (index >= 0) {
    while (first > 0 && sortedArr[first-1] == value)
        first--;
    while (last < sortedArr.length - 1 && sortedArr[last+1] == value)
        last++;
}