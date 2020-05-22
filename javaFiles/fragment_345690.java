int len = array.length;
for (int i=0; i<len; i++){
    //my first idea of how you want it
    array[i] = array[i] * len - i;
    //or this way?
    array[i] = array[i] * (len-i);
}