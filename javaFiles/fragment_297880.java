public boolean isEvens (int[] array){
    for (int i = 0; i < array.length; i++) {
        if (array[i] % 2 != 0) {
            return false;
        } 
    }
    return true;
}