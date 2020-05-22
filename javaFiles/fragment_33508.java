int index = (low+high)/2;
int pivot = array[index];

if(desired<pivot){
    return binarySearch(array,low,index - 1, desired);
}else if(desired>pivot){
    return binarySearch(array, index+1, high, desired);
}else {
    return index;
}