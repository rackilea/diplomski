if(left < index) {
    quickSort(a,left,index-1);
}
else {
    quickSort(a,index,length);
}