for(int j = 0; j < array.length; j++){
    for(int i = 0; i < array[j].length / 2; i++) {
        int temp = array[j][i];
        array[j][i] = array[j][array[j].length - i - 1];
        array[j][array[j].length - i - 1] = temp;
    }
}