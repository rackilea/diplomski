// hostIndex is no longer required - remove the line below:
// int hostIndex = 0;
for(int index = stringArr.length-1 ; index>=0 ; index--){
    if(index == stringArr.length-1) {
        hostArray[index] = stringArr[index];
    }
    else{
        hostArray[index] = stringArr[index]+"."+hostArray[index+1];
    }
}