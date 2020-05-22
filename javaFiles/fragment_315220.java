public E[] reverse() {
    for (int i = 0; i < size/2; i++){
        E tmp=array[i];  
        array[i] = array[size - i - 1];
        array[size - i - 1]=tmp;
    }
    return array; // If you really want to return it
}