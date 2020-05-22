while(i<=length){
    if(array[i]!=' '){
        i++;
    }
    else{
        reverseString(array, start, i-1);
        start = i+1;
    }
}